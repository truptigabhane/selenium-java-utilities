package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test90
{
	public static void main(String[] args) throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site 
		driver.get("http://www.facebook.com");
		Thread.sleep(5000); 
		//fill fields
		driver.findElement(By.name("email")).sendKeys("abdulkalam",
											Keys.chord(Keys.CONTROL,"a"),
											Keys.chord(Keys.CONTROL,"c"));
		Thread.sleep(5000); 
		driver.findElement(By.name("pass")).sendKeys(Keys.chord(Keys.CONTROL,"v"));
		
	}

}
