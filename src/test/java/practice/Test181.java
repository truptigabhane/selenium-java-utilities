package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test181
{
	public static void main(String[] args)
	{
		//Open browser and launch site
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");
		//Locate and operate elements
		FluentWait<ChromeDriver> w=new FluentWait<ChromeDriver>(driver);
		w.withTimeout(Duration.ofSeconds(20));
		w.pollingEvery(Duration.ofMillis(1000));
		WebElement uid=w.until((ChromeDriver d) -> {
            WebElement e=d.findElement(By.name("email"));
            String c=e.getAttribute("aria-label");
            return(c.contains("Email address") ? e : null);
        });
		uid.sendKeys("abdulkalam");
	}
}