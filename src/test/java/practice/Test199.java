package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test199
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
		//locate element and change source of that element
		WebElement e=driver.findElement(By.name("q"));
		//change-1: background color to green
		driver.executeScript("arguments[0].style.background='green';",e); 
		Thread.sleep(5000);
		//change-2: enter text in red color
		driver.executeScript("arguments[0].style.color='red';",e);
		driver.executeScript("arguments[0].value='abdul kalam';",e);
		Thread.sleep(5000);
		//change-3: highlight that element with solid line in blue
		driver.executeScript("arguments[0].style.border='5px blue dotted';",e);
		Thread.sleep(5000);
	}
}
