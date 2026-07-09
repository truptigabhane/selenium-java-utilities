package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test236 
{
	public static void main(String args[]) throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Create an object to ListenerBodies class
		ListenerBodies lb=new ListenerBodies();
		//Create object to EventFiringWebDriver object
		EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
		edriver.register(lb);
		edriver.get("http://www.google.co.in");
		edriver.findElement(By.name("q")).sendKeys("kalam");
	}
}
