package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ActionsUtility;

public class Test182 
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and define wait
		WebDriverManager.chromedriver().setup(); 
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(1000));
		//launch site and close banner if exists
		driver.get("https://www.flipkart.com");
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@role='button']"))).click();
		}
		catch(Exception ex)
		{
			System.out.println("no banner");
		}
		//Locate an element
		ActionsUtility obj=new ActionsUtility(driver,wait);
		WebElement e1=wait.until(ExpectedConditions.elementToBeClickable(
				                                    By.xpath("//div[@aria-label='Fashion']")));
		obj.focusOnElementCenter(e1);
		Thread.sleep(5000);
		WebElement e2=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Women Footwear")));
		obj.focusOnElementCenter(e2);
		Thread.sleep(5000);
		WebElement e3=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Women Sneakers")));
		obj.focusOnElementCenter(e3);
		
		
		
		
		
		
		
	}
}
