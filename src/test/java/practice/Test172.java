package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test172
{
	public static void main(String[] args) 
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Define wait object along with timeout and interval time
		FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(1000)); 
		//launch site
		driver.get("https://www.facebook.com");
		//do login
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")))
															.sendKeys("abdulkalam");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("pass")))
		                                                    .sendKeys("abdulkalam");
		wait.until(ExpectedConditions.elementToBeClickable(By.name("login"))).click();
		wait.until(ExpectedConditions.textToBe(By.name("tryanotherway"),"Try another way"));
		driver.close();
	}
}







