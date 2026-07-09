package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test207
{
	public static void main(String[] args) throws Exception
	{
		//Page scrolling
		//Open browser and launch site
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
	driver.get("https://stackoverflow.com/questions/38653910/actions-click-script-selenium");
		Thread.sleep(5000);
		Actions a=new Actions(driver);
		//locate and move to an element at end of the page
		WebElement e1=driver.findElement(By.linkText("Contact Us")); 
		a.moveToElement(e1).perform();
		Thread.sleep(5000);
		//locate and move to an element at top of the page
		WebElement e2=driver.findElement(By.partialLinkText("Ask Question")); 
		a.moveToElement(e2).perform();
	}
}
