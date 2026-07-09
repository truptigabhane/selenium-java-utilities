package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test26
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
		Thread.sleep(5000);
		//switch to frame using index
		driver.switchTo().frame(1); //2nd frame in page source
		//fill fields
		driver.findElement(By.name("fname")).clear(); 
		driver.findElement(By.name("fname")).sendKeys("abdul"); 
		driver.findElement(By.name("lname")).clear();
		driver.findElement(By.name("lname")).sendKeys("kalam sir");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent(); //back to page
		//Close site
		driver.close();
	}
}
