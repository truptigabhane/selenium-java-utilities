package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test73
{
	public static void main(String[] args)
	{
		//download latest browser driver software 
		WebDriverManager.chromedriver().setup();
		//open browser window by using that driver software
		RemoteWebDriver	driver=new ChromeDriver();
		//Maximise that browser window
		driver.manage().window().maximize();
		//Launch site(SWD code waits for complete loading of the page by default)
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
		//define implicit wait at top of the automation code for waiting if required
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		//automation code once page is ready
		driver.switchTo().frame("iframeResult"); 
		driver.findElement(By.name("fname")).clear(); //to remove existing value
		driver.findElement(By.name("fname")).sendKeys("abdul"); 
		driver.findElement(By.name("lname")).clear(); //to remove existing value
		driver.findElement(By.name("lname")).sendKeys("kalam sir");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		driver.switchTo().defaultContent(); //back to page
		driver.close();
	}
}
//sometimes above code will fail, because implicitlyWit() method is not consistent.


















