package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test234UseOpenedBrowser
{
	public static void main(String[] args)
	{
		//connect to existing browser
		ChromeOptions o=new ChromeOptions();
	    o.setExperimentalOption("debuggerAddress","localhost:62121");
		ChromeDriver driver=new ChromeDriver(o);
		driver.findElement(By.name("q")).sendKeys("abdul kalam");
	}
}
