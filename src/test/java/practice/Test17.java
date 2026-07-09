package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test17 
{
	public static void main(String[] args) throws Exception
	{
		//open chrome browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.gmail.com"); //base url
		Thread.sleep(5000);
		//locate an element in page source and then fill that element
		driver.findElement(By.id("identifierId")).sendKeys("asdfdfzx675");
		driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()=\"Couldn’t find your Google Account\"]"));
		
		
	}
}







