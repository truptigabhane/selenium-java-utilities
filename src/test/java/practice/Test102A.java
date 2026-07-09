package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test102A
{
	public static void main(String[] args) throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site(operation)
		driver.get("https://www.gmail.com");
		Thread.sleep(5000);
		//Locate element
		WebElement e=driver.findElement(By.xpath("//button[text()='Forgot email?']"));
		//before right click
		String x1=e.getCssValue("color");
		System.out.println(x1);
		String x2=e.getCssValue("background-color");
		System.out.println(x2);
		//Move focus to "Forgot email" button via tabs
		driver.findElement(By.id("identifierId")).sendKeys(Keys.TAB);
		Thread.sleep(5000);
		//after focus
		String y1=e.getCssValue("color");
		System.out.println(y1);
		String y2=e.getCssValue("background-color");
		System.out.println(y2);
		//border is coming as pseudo-element
		String y3=(String) driver.executeScript(
				"var ps=window.getComputedStyle(arguments[0],'::after');" + 
				"var s=ps.getPropertyValue('color');" + 
				"return(s);",e);
		System.out.println(y3);
		//close site
		driver.close();
	}
}