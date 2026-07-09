package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test84SameBrowserType
{
	RemoteWebDriver driver;
	@Test(priority=1)
	public void method1() throws Exception
	{
		//Open chrome browser
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(); //opens without history and cookies by default
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Launch fast mail site
		driver.get("http://www.fastmail.com");
		Thread.sleep(5000);
	}
	@Test(priority=2)
	public void method2() throws Exception
	{
		//do login
		driver.findElement(By.xpath("//strong[text()='Log in']/parent::a")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("username")).sendKeys("magnitiait");
		driver.findElement(By.name("password")).sendKeys("Magnitia@264");
		driver.findElement(By.xpath("//span[text()='Log in']/parent::button")).click();
		Thread.sleep(5000);
	}
	@Test(priority=3)
	public void method3() throws Exception
	{
		//take new window/tab in chrome and switch to that new window/tab
		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> swh=driver.getWindowHandles(); 
		List<String> lwh=new ArrayList<String>(swh); 
		driver.switchTo().window(lwh.get(1));
		//Launch same site by skipping login due to session cookie
		driver.get("http://www.fastmail.com");
		Thread.sleep(5000);
		try
		{
			if(driver.findElement(By.xpath("//div[text()='Settings']")).isDisplayed())
			{
				System.out.print("Login Session cookie is working correctly");
			}
		}
		catch(Exception ex)
		{
			System.out.print("Login Session cookie is not working correctly");
		}
	}
	@Test(priority=4)
	public void method4() throws Exception
	{
		//close all browser windows/tabs
		driver.quit();
	}
}
