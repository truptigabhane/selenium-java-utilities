package practice;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.CookiesUtility;

public class Test83
{
	RemoteWebDriver driver;
	CookiesUtility obj;
	List<Cookie> l;
	@Test(priority=1)
	public void methoid1() throws Exception
	{
		//Open browser
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//Maximise browser
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Launch site
		driver.get("http://www.youtube.com");
		Thread.sleep(5000);
	}
	@Test(priority=2)
	public void methoid2() throws Exception
	{
		obj=new CookiesUtility();
		//Create any type of cookie(7 types) using "Cookie.Builder" class(way-2)
	    Date today=new Date();
	    Date target=new Date(today.getTime()+(3000)); //cookie lifetime is 3 seconds
	    obj.addNewCookieViaBuilder(driver,"session-id-time","magnitia","www.youtube.com","/",
	    		target,true,false,"Strict");
	}
	@Test(priority=3)
	public void methoid3() throws Exception
	{
		//Collect all cookies
		List<String> cl1=obj.getCookiesList(driver);
		for(String c:cl1)
		{
			System.out.println(c);
		}
		//waiting for 5 seconds
		Thread.sleep(5000); 
		//Collect all cookies after waiting
		List<String> cl2=obj.getCookiesList(driver);
		for(String c:cl2)
		{
			System.out.println(c);
		}
	}
	@Test(priority=4)
	public void methoid4() throws Exception
	{
		//Close site
		driver.close();
	}
}

