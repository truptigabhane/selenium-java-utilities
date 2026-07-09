package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test120
{
	@Test
	public void method() throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site 
		driver.get("https://books-pwakit.appspot.com");
		Thread.sleep(5000); 
		//Element under a single shadow DOM.
		driver.findElement(By.xpath("//book-app[@apptitle='BOOKS']")) //Goto shadow host
		      .getShadowRoot() //Goto shadow root
		      .findElement(By.id("input")).sendKeys("abdul kalam"); //Goto target element
		
	}
}
