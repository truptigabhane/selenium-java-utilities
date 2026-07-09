package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test179
{
	public static void main(String[] args)
	{
		//Open browser and launch site
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//define wit object
		FluentWait<ChromeDriver> w=new FluentWait<ChromeDriver>(driver);
		w.withTimeout(Duration.ofSeconds(20));
		w.pollingEvery(Duration.ofMillis(1000));
		//Launch site
		driver.get("http://www.gmail.com");
		//Locate and operate an element
		WebElement e=w.until(visibilityOfElementLocated(By.name("identifier")));
		e.sendKeys("magnitiait");
		//goto next page(new DOM/page-source)
		w.until(elementToBeClickable(
				By.xpath("//span[text()='Next']/parent::button"))).click(); 
		w.until(visibilityOfElementLocated(By.xpath("//a[@aria-label='Try again']")));
		//back to previous page(back to previous DOM/page-source)
		driver.navigate().back(); 
		//verify that element is staled or not due to DOM changes
		if(w.until(stalenessOf(e)))
		{
			//Relocate element if that element is staled
			e=w.until(refreshed(visibilityOfElementLocated(By.name("identifier"))));
		} 
		//Operate that element
		e.clear();
		e.sendKeys("abdulkalam");
	}
}
