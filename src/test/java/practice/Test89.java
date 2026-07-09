package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test89
{
	public static void main(String[] args) throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site 
		driver.get("http://www.facebook.com");
		Thread.sleep(5000); 
		//fill userID field
		driver.findElement(By.name("email")).sendKeys("abdul");
		Thread.sleep(3000);
		//Fill password and click on sign-in button via keyboard automation
		driver.findElement(By.name("email"))
	       .sendKeys(Keys.TAB,"kalam",Keys.TAB,Keys.TAB,Keys.ENTER);
	}
}








