package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test20 
{
	public static void main(String[] args) throws Exception
	{
		//open chrome browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://www.facebook.com/"); //base url
		Thread.sleep(5000);
		//do login
		driver.findElement(By.id("email")).sendKeys("asddffg");
		driver.findElement(By.id("pass")).sendKeys("qwert");
		driver.findElement(By.xpath("//*[@id='u_0_5_Dt]")).click();
		

	}

}






