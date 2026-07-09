package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Test121
{
	@Test
	public void method() throws Exception
	{
		//open browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site 
		driver.get("chrome://settings/");
		Thread.sleep(5000); 
		//This Element is inside of nested shadow DOM.
		driver.findElement(By.tagName("settings-ui")) //Goto Shadow host
			  .getShadowRoot() //Goto shadow root
		      .findElement(By.id("toolbar")) //Goto Shadow host
		      .getShadowRoot() //Goto Shadow root
		      .findElement(By.id("search")) //Goto Shadow host
		      .getShadowRoot() //Goto Shadow root
		      .findElement(By.id("searchInput")).sendKeys("abdulkalam"); //Goto target element
	}
}
