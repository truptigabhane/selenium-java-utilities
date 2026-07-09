package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test211
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
	driver.get("https://stackoverflow.com/questions/38653910/actions-click-script-selenium");
		Thread.sleep(5000);
		//Get visibility of element of page in desktop 
		WebElement e=driver.findElement(By.xpath("(//pre)[1]"));
		driver.executeScript("arguments[0].scrollIntoView();",e);
		Thread.sleep(5000);
		//element Scroll down
		driver.executeScript("var x=arguments[0].scrollHeight; arguments[0].scrollTop=x;",e);
		Thread.sleep(5000);
		//element scroll up
		driver.executeScript("arguments[0].scrollTop=0;",e);
		Thread.sleep(5000);
		//element scroll right
		driver.executeScript("var x=arguments[0].scrollWidth; arguments[0].scrollLeft=x;",e);
		Thread.sleep(5000);
		//element scroll left
		driver.executeScript("arguments[0].scrollLeft=0;",e);
		Thread.sleep(5000);	
		//Close site
		driver.close(); 
	}
}
