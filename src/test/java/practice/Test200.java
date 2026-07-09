package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test200
{
	@Test
	public void method() throws Exception
	{
		//Open browser and Launch site
		WebDriverManager.chromedriver().setup();    
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//locate element via SWD-java
		WebElement e1=driver.findElement(By.name("q"));
		//change-1: Disable element and then back to enable
		driver.executeScript("arguments[0].disabled=true;",e1);
		Thread.sleep(5000);
		driver.executeScript("arguments[0].disabled=false;",e1);
		Thread.sleep(5000);
		//change-2: change type of element
		driver.executeScript("arguments[0].setAttribute('type','checkbox');",e1);
		Thread.sleep(5000);
		//change-3: Remove an element
		WebElement e2=driver.findElement(By.xpath("//*[@aria-label='Search by voice']"));
		driver.executeScript("arguments[0].remove();",e2);
		Thread.sleep(5000);
		//change-4: add new plain text element
		WebElement e3=driver.findElement(By.xpath("//input[@name='q']/parent::div"));
		driver.executeScript(
				"var para=document.createElement('p');"
				+"var tn=document.createTextNode('Hi Batch262, please wakeup');"
				+ "para.appendChild(tn); "
				+ "arguments[0].appendChild(para);",e3);
		Thread.sleep(5000); 
	}
}






