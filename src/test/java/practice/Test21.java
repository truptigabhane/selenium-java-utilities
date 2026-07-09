package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test21
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
		Thread.sleep(5000);
		//switch to frame by using "frame id/name" or "frame index" or "as an element"
		driver.switchTo().frame("iframeResult"); 
		//fill fields
		driver.findElement(By.name("fname")).clear(); //to remove existing value
		driver.findElement(By.name("fname")).sendKeys("abdul"); 
		Thread.sleep(5000);
		driver.findElement(By.name("lname")).clear(); //to remove existing value
		driver.findElement(By.name("lname")).sendKeys("kalam sir");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent(); //back to page
		//Close site
		//driver.close();
	}
}
