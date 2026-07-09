package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test180
{
	public static void main(String[] args)
	{
		//Open browser and launch site
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.gmail.com");
		//Locate and operate elements
		FluentWait<ChromeDriver> w=new FluentWait<ChromeDriver>(driver);
		w.withTimeout(Duration.ofSeconds(20));
		w.pollingEvery(Duration.ofMillis(1000));
		w.until(waitandfill(By.name("identifier"),"magnitiait"));
		w.until(waitandclick(By.xpath("//span[text()='Next']/parent::button")));
	}
	
	public static ExpectedCondition<Boolean> waitandclick(By b)
	{
		ExpectedCondition<Boolean> ec=new ExpectedCondition<Boolean>() 
		{
	        public Boolean apply(WebDriver driver) 
	        {
	        	try 
	           	{
	        	   driver.findElement(b).click();
	        	   return(true);
	            } 
	            catch(Exception ex) 
	            {
	            	return(false);
	            }
	         }
	    };
	    return(ec);
	}
		
	public static ExpectedCondition<Boolean> waitandfill(By b, String x)
	{
		ExpectedCondition<Boolean> ec=new ExpectedCondition<Boolean>() 
		    {
	            public Boolean apply(WebDriver driver) 
	            {
	            	try 
	            	{
	            		driver.findElement(b).sendKeys(x);
	            		return(true);
	            	} 
	            	catch(Exception ex) 
	            	{
	            		return(false);
	            	}
	            }
	        };
	    return(ec);
	}
}
