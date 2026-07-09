package practice;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test85DifferentBrowserTypes
{
	RemoteWebDriver driver1;
	RemoteWebDriver driver2;
	ArrayList<Cookie> l;
	@Test(priority=1)
	public void method1() throws Exception
	{
		//Open chrome browser
		WebDriverManager.chromedriver().setup();
		driver1=new ChromeDriver();//opens without history and cookies by default
		driver1.manage().window().maximize();
		//Launch fast mail site
		driver1.get("http://www.fastmail.com");
		Thread.sleep(5000);
	}
	@Test(priority=2)
	public void method2() throws Exception
	{
		//do login
		driver1.findElement(By.xpath("//strong[text()='Log in']/parent::a")).click();
		Thread.sleep(5000);
		driver1.findElement(By.name("username")).sendKeys("magnitiait");
		driver1.findElement(By.name("password")).sendKeys("Magnitia@264");
		driver1.findElement(By.xpath("//span[text()='Log in']/parent::button")).click();
		Thread.sleep(5000);
		//Collect all cookies from chrome browser
		Set<Cookie> s=driver1.manage().getCookies();
		l=new ArrayList<Cookie>(s);
	}
	@Test(priority=3)
	public void method3() throws Exception
	{
		//Take new window in firefox browser
		WebDriverManager.firefoxdriver().setup();
        driver2=new FirefoxDriver();
        //Launch same site
        driver2.get("http://www.fastmail.com"); 
      	Thread.sleep(5000);
      	//Add cookies from chrome to firefox and then refresh
      	for(Cookie c:l)
		{
			try
			{
				driver2.manage().addCookie(c);
			}
			catch(Exception ex)
			{
			}
		}
      	driver2.navigate().refresh();
      	Thread.sleep(5000); 
      	try
		{
			if(driver2.findElement(By.xpath("//div[text()='Settings']")).isDisplayed())
			{
				System.out.println("Session cookie test failed");
				System.out.println("HTTPS based sites cannot respond for shared cookies "
						+"from one type of browser to another type due to different encryptions,"
						+ "but here chrome cookies working for firefox. so security test failed");
			}
		}
		catch(NoSuchElementException ex)
		{
			System.out.println("Session cookie test passed");
			System.out.println("HTTPS based sites cannot respond for shared cookies "
					+"from one type of browser to another type due to different encryptions,"
					+ "so security test passed here");
		}
	}
	@Test(priority=3)
	public void method4() throws Exception
	{
      	//Close browsers
      	driver1.close();
      	driver2.close();
	}
}
