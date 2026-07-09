package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test101
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
		//right click
		Actions act=new Actions(driver);
		act.contextClick(e).perform();
		Thread.sleep(5000);
		//after right click
		String y1=e.getCssValue("color");
		System.out.println(y1);
		String y2=e.getCssValue("background-color");
		System.out.println(y2);
		if(!x1.equals(x2) && !y1.equals(y2))
		{
			System.out.println("Test passed because of changes after right click");
		}
		else
		{
			System.out.println("Test failed due to same after right click");
		}
		//close site
		driver.close();
	}
}