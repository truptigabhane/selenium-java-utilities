package practice;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test219
{
	public static void main(String[] args)
	{
		//Range slider with min and max both will be changed from right to left
		//Take value from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter min value as <75");
		int min=sc.nextInt(); //99
		System.out.println("Enter max value as <300");
		int max=sc.nextInt(); //349
		sc.close();
		//Open browser and launch site
		WebDriverManager.chromedriver().setup();         
        RemoteWebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withTimeout(Duration.ofSeconds(20));
		driver.get("https://jqueryui.com/slider/#range");
		//set values in range slider
		driver.switchTo().frame(0);
	    WebElement minslider=wait.until(ExpectedConditions.visibilityOfElementLocated(
	    		                        By.xpath("//div[@id='slider-range']/span[1]")));
	    Actions act=new Actions(driver);
    	act.clickAndHold(minslider).perform();
	    while(true)
	    {
	    	WebElement amount=driver.findElement(By.id("amount"));
	    	String temp=amount.getAttribute("value");
	    	System.out.println(temp);
	    	if(temp.contains("$"+min) || temp.contains("$"+(min-1)))
	    	{
	    		act.release().perform();
	    		break;
	    	}
	    	else
	    	{
	    		act.sendKeys(Keys.LEFT).perform();
	    		//here, one pixel means $2
	    	}
	    }
	    WebElement maxslider=wait.until(ExpectedConditions.visibilityOfElementLocated(
                						By.xpath("//div[@id='slider-range']/span[2]")));
	    while(true)
	    {
	    	WebElement amount=driver.findElement(By.id("amount"));
	    	String temp=amount.getAttribute("value");
	    	System.out.println(temp);
	    	if(temp.contains("- $"+max))
	    	{
	    		break;
	    	}
	    	else
	    	{
	    		act.dragAndDropBy(maxslider,-1,0).perform();
	    		//here 1 pixel means $1
	    	}
	    }
	    
	}
}







