package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ActionsUtility;

public class Test184
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")))
		                                                         .sendKeys("bse sensex",Keys.ENTER);
		//move to specific location of element
		WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated(
		  By.xpath("((//*[text()='BSE SENSEX'])[2]/following::*[name()='svg']//*[name()='g'])[1]")));
		obj.focusOnElementLocation(e,-250,100); 
		//positive XOffset to goto right side from centre
		//Negative XOffset to goto left side from centre
		//positive YOffset to goto bottom from centre
		//Negative YOffset to goto top from centre
	}
}





