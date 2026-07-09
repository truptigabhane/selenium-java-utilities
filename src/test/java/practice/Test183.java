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

public class Test183
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
		driver.get("http://www.google.co.in");
		ActionsUtility obj=new ActionsUtility(driver,wait);
		//move to element
		WebElement e1=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Images")));
		obj.focusOnElementCenter(e1);
		Thread.sleep(5000);
		//Right click on element
		WebElement e2=driver.findElement(By.name("q"));
		obj.rightClickOnElement(e2);
		Thread.sleep(5000);
		//Double click on element
		WebElement e3=driver.findElement(By.linkText("Gmail"));
		obj.doubleClickOnElement(e3);
		//close site
		driver.close();
	}
}





