package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

public class Test232
{
	@Test
	public void method() throws Exception
	{
		//Open browser
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site and get latitude and longitude values of current location
		driver.get("https://the-internet.herokuapp.com/geolocation");
		FluentWait<ChromeDriver> w=new FluentWait<ChromeDriver>(driver);
		w.withTimeout(Duration.ofSeconds(20));
		w.pollingEvery(Duration.ofMillis(500));
		w.until(ExpectedConditions.elementToBeClickable(
				               By.xpath("//button[text()='Where am I?']"))).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("lat-value")));
		String la1=driver.findElement(By.id("lat-value")).getText();
		String lo1=driver.findElement(By.id("long-value")).getText();
		System.out.println(la1+" "+lo1); 
		Thread.sleep(5000);
		//Create DevTools session and set latitude and longitude values of desired location
		DevTools dt=driver.getDevTools();
		dt.createSession();
        driver.executeCdpCommand("Emulation.setGeolocationOverride",
          ImmutableMap.of("latitude",23.033863,"longitude",72.585022,"accuracy", 1));
        //Get latitude and longitude values after change
        w.until(ExpectedConditions.elementToBeClickable(
	                                 By.xpath("//button[text()='Where am I?']"))).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.id("lat-value")));
        String la2=driver.findElement(By.id("lat-value")).getText();
        String lo2=driver.findElement(By.id("long-value")).getText();
        System.out.println(la2+" "+lo2);
	}
}
