package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.CookiesUtility;

public class Test78
{
	RemoteWebDriver driver;
	CookiesUtility obj;
	@Test(priority=1)
	public void methoid1() throws Exception
	{
		//Open browser
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//Maximize browser
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Launch site
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
	}
	@Test(priority=2)
	public void methoid2() throws Exception
	{
		System.out.println("Cookies after Launching site:");
		System.out.println("-------------------------------");
		obj=new CookiesUtility();
		System.out.println(obj.getCookiesCount(driver));
		System.out.println(obj.getCookiesList(driver));
		List<String> types1=obj.getCookiesTypes(driver,"google.co.in","google.com");
		for(String type:types1)
		{
			System.out.println(type);
		}
	}
	@Test(priority=3)
	public void methoid3() throws Exception
	{
		//Do Search
		driver.findElement(By.name("q")).sendKeys("abdul kalam",Keys.ENTER); 
		Thread.sleep(5000);
		System.out.println("Cookies after searching a word:");
		System.out.println("-------------------------------");
		System.out.println(obj.getCookiesCount(driver));
		System.out.println(obj.getCookiesList(driver));
		List<String> types2=obj.getCookiesTypes(driver,"google.co.in","google.com");
		for(String type:types2)
		{
			System.out.println(type);
		}
	}
	@Test(priority=4)
	public void methoid4() throws Exception
	{
		//Close site
		driver.close();
	}
}
