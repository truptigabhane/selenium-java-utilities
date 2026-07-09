package practice;

import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.CookiesUtility;

public class Test77
{
	RemoteWebDriver driver;
	CookiesUtility obj; 
	@Test
	public void method1() throws Exception
	{
		//Open browser
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//Maximise browser
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Launch site
		driver.get("http://www.facebook.com");
		Thread.sleep(5000);
	}
	@Test
	public void method2() throws Exception
	{
		System.out.println("Cookies after Launching site:");
		System.out.println("-------------------------------");
		obj=new CookiesUtility();
		System.out.println(obj.getCookiesCount(driver));
		System.out.println(obj.getCookiesList(driver));
		//No super domain to "facebook.com", so we used same domain for same site and super
		List<String> types=obj.getCookiesTypes(driver,"facebook.com","facebook.com");
		for(String type:types)
		{
			System.out.println(type);
		}
		obj.deleteCookies(driver);
	}
	@Test
	public void method3() throws Exception
	{
		//Close site
		driver.close();
	}
}
