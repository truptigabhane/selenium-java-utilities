package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test75
{
	public static void main(String[] args)
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver	driver=new ChromeDriver();
		Duration d=driver.manage().timeouts().getScriptTimeout();
		System.out.println(d.getSeconds()); //30 seconds
		driver.manage().timeouts().setScriptTimeout(Duration.ofMillis(3));
		//Launch site
		driver.get("https://www.gmail.com");
		WebElement e=driver.findElement(By.name("identifier"));
        driver.executeScript("arguments[0].style.border='5px red solid';",e);
	}
}





