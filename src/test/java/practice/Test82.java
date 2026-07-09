package practice;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.CookiesUtility;

public class Test82
{
	RemoteWebDriver driver;
	CookiesUtility obj;
	List<String> cl;
	@Test(priority=1)
	public void methoid1() throws Exception
	{
		//Open browser
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//Maximise browser
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://www.google.com"); 
		Thread.sleep(5000);
	}
	@Test(priority=2)
	public void methoid2() throws Exception
	{
		//Create any type of cookie(7 types) and add to the current WebDriver's cookies(way-1)
        String cookieName="session-id";
        String cookieValue="12345";
        String domain="google.com";
        String path="/"; //fixed value
        Date expiryDate=null; // Session cookie, no expiration date
        boolean isSecure=false;
        boolean isHttpOnly=true;
        String sameSite="Lax"; //either "Strict" or "Lax"
        obj=new CookiesUtility();
        obj.addNewCookie(driver, cookieName, cookieValue, domain, path, expiryDate, 
        		                                   isSecure, isHttpOnly, sameSite);
	}
	@Test(priority=3)
	public void methoid3() throws Exception
	{
		System.out.println("Count of cookies is "+obj.getCookiesCount(driver));
		//Collect all loaded cookies along with added cookie
		cl=obj.getCookiesList(driver);
		for(String c:cl)
		{
			System.out.println(c);
		}
	}
	@Test(priority=4)
	public void methoid4() throws Exception
	{
		//Get specific cookie using cookie's name
		Cookie c=driver.manage().getCookieNamed("session-id");
		System.out.println(c.getName()+"----"+c.getValue()+"----"+c.getDomain());
		//Delete specific cookie using Cookie class's object
		Set<Cookie> s=driver.manage().getCookies();
		List<Cookie> l=new ArrayList<Cookie>(s);
		driver.manage().deleteCookie(l.get(1)); //2nd cookie in list
		//Delete specific cookie using name
		driver.manage().deleteCookieNamed("session-id");
		//delete all cookies
		obj.deleteCookies(driver);
		//Close site
		driver.close();
	}
}

