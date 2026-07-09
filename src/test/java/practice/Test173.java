package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test173
{
	public static void main(String[] args)
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Define wait object
		FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(1000)); 
		//launch site
		driver.get("http://dev.worke.io/register");
		wait.until(urlContains("https"));
		//fill page
		wait.until(visibilityOfElementLocated(By.id("first_name")))
		                                                           .sendKeys("abdul");
		wait.until(visibilityOfElementLocated(By.id("last_name")))
																.sendKeys("kalam");
		wait.until(visibilityOfElementLocated(By.id("useremail")))
														.sendKeys("apj@abdulkalam.com");
		wait.until(visibilityOfElementLocated(By.id("phone_number")))
		                                                .sendKeys("9876556789");
		wait.until(visibilityOfElementLocated(By.id("userpassword")))
        												.sendKeys("batch261");
		wait.until(visibilityOfElementLocated(
			By.xpath("//input[@placeholder='Business Name']")))
		      .sendKeys("teaching.worke.io");
		wait.until(elementToBeClickable(
				By.xpath("//button[text()='Register']"))).click();
		
	}

}
