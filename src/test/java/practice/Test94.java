package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test94
{
	public static void main(String[] args) throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site 
		driver.get("https://www.gmail.com");
		Thread.sleep(5000); 
		//fill an element
		driver.findElement(By.name("identifier")).sendKeys("magnitiait");
		Thread.sleep(5000);
		//clear data in an element
		driver.findElement(By.name("identifier")).clear();
		Thread.sleep(5000); 
	}
}
