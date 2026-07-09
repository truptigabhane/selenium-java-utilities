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

public class Test187
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		WebDriverManager.chromedriver().setup(); 
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(1000));
		//Launch site
		driver.get("https://jqueryui.com/slider");
		//Horizontal slider
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		WebElement e1=driver.findElement(By.id("slider"));
		ActionsUtility obj=new ActionsUtility(driver,wait);
		Thread.sleep(5000);
		obj.moveSlider(e1, 100, 0); //left to right
		Thread.sleep(5000);
		obj.moveSlider(e1,-100, 0); //right to left
		driver.switchTo().defaultContent();
		//Vertical slider
		wait.until(ExpectedConditions.elementToBeClickable(
				                 By.linkText("Vertical slider"))).click();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		WebElement e2=wait.until(ExpectedConditions.elementToBeClickable(
				                                   By.id("slider-vertical")));
		Thread.sleep(5000);
		obj.moveSlider(e2, 0, 100); //top to bottom
		Thread.sleep(5000);
		obj.moveSlider(e2, 0, -100); //bottom to top
		driver.switchTo().defaultContent();
	}
}





