package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test188Problem
{
	public static void main(String[] args) throws Exception
	{
		//Drag and Drop between two elements in two different frames
		//Setting up chrome driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Redirecting to the web site
		driver.get("https://codepen.io/rjsmer/full/vvewWp");
		Thread.sleep(10000);
		driver.switchTo().frame(0); //outer frame in page
		driver.switchTo().frame(0); //1st inner frame in page
		WebElement drag=driver.findElement(By.id("dragFrame-0"));
		driver.switchTo().parentFrame(); //back to outer frame
		driver.switchTo().frame(1); //2nd inner frame in page
		WebElement drop=driver.findElement(By.xpath("//li[@id='element2-1']/parent::ul"));
		Actions act=new Actions(driver);
		act.dragAndDrop(drag, drop).perform(); //StaleElementReferenceException
		
	}
}





