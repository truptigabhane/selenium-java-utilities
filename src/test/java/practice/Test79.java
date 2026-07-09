package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.CookiesUtility;

public class Test79
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//Maximize browser
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Launch site
		driver.get("http://www.yahoomail.com");
		Thread.sleep(5000);
		System.out.println("Cookies after Launching site:");
		System.out.println("-------------------------------");
		CookiesUtility obj=new CookiesUtility();
		System.out.println(obj.getCookiesCount(driver));
		System.out.println(obj.getCookiesList(driver));
		List<String> types1=obj.getCookiesTypes(driver,"yahoomail.com","yahoo.com");
		for(String type:types1)
		{
			System.out.println(type);
		}
		//Do login
		driver.findElement(By.linkText("Sign in")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("login-username")).sendKeys("magnitiabatch251");
		driver.findElement(By.id("login-signin")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("login-passwd")).sendKeys("Magnitia251");
		driver.findElement(By.id("login-signin")).click();
		Thread.sleep(5000);
		System.out.println("Cookies after Login to site:");
		System.out.println("-------------------------------");
		System.out.println(obj.getCookiesCount(driver));
		System.out.println(obj.getCookiesList(driver));
		List<String> types2=obj.getCookiesTypes(driver,"yahoomail.com","yahoo.com");
		for(String type:types2)
		{
			System.out.println(type);
		}
		//Do logout
		driver.findElement(By.id("ybarAccountMenuOpener")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("profile-signout-link")).click();
		Thread.sleep(5000);
		System.out.println("Cookies after Logout from site:");
		System.out.println("-------------------------------");
		System.out.println(obj.getCookiesCount(driver));
		System.out.println(obj.getCookiesList(driver));
		List<String> types3=obj.getCookiesTypes(driver,"yahoomail.com","yahoo.com");
		for(String type:types3)
		{
			System.out.println(type);
		}
		//Close site
		driver.close();
	}
}
