package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test95
{
	public static void main(String[] args) throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site 
		driver.get("http://www.gmail.com");
		Thread.sleep(5000); 
		//"ElementNotInteractableException" due to clear a hidden element
		driver.findElement(By.name("hiddenPassword")).clear();
	
	}

}
