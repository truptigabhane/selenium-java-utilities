package practice;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test115
{
	public static void main(String[] args) throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site 
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_disabled");
		Thread.sleep(5000); 
		//take screenshot of a disabled element
		driver.switchTo().frame("iframeResult");
		WebElement e=driver.findElement(By.name("lname"));
		File dest=new File("target\\disabledelementpic.png"); 
		File src=e.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,dest);
		//close site
		driver.close();
	}
}
