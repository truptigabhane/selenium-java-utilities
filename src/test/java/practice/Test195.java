package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.locators.RelativeLocator.RelativeBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test195
{
	@Test
	public void method() throws Exception
	{
		//Open browser
		WebDriverManager.chromedriver().setup(); 
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(1000));
		//Launch site
		driver.get("http://www.google.co.in");
		//close banner if exists
		try
		{
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("callout"));
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//button[text()='No thanks']"))).click();
			driver.switchTo().defaultContent(); //back to page
		}
		catch(Exception ex)
		{
			System.out.println("No banner");
		}
		//Locate an element via visual relations with other elements in page
		WebElement e=driver.findElement(By.name("q"));
		RelativeBy rb=RelativeLocator.with(By.tagName("svg"));
		List<WebElement> targets=driver.findElements(rb.near(e,100));
		System.out.println(targets.size());
		for(WebElement target:targets)
		{
			driver.executeScript("arguments[0].style.border='2px solid red';", target);
			Thread.sleep(5000);
		}
		targets.get(1).click(); //2nd target element (mic)
		
	}
}
