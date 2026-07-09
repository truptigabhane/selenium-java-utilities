package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test208
{
	public static void main(String[] args) throws Exception
	{
		//Page scrolling
		//(top to bottom, bottom to top, left to right, right to left, and to specific element)
		//Open browser and launch site
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		Thread.sleep(5000);
		//Change browser widow size to get scroll bars
		Dimension d=new Dimension(500,400); //width and height
		driver.manage().window().setSize(d);
		Thread.sleep(5000);
		//Scroll down
		//driver.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		driver.executeScript("window.scrollBy(0,document.body.scrollHeight);");
		Thread.sleep(5000);
		//Scroll up
		//driver.executeScript("window.scrollTo(document.body.scrollHeight,0);");
		driver.executeScript("window.scrollBy(0,-(document.body.scrollHeight));");
		Thread.sleep(5000);
		//Scroll right
		driver.executeScript("window.scrollBy(document.body.scrollWidth,0);");
		Thread.sleep(5000);
		//Scroll left
		driver.executeScript("window.scrollBy(-(document.body.scrollWidth),0);");
		Thread.sleep(5000);
		//Scroll to specific element in page
		WebElement e=driver.findElement(By.name("email"));
		driver.executeScript("arguments[0].scrollIntoView();",e);
		Thread.sleep(5000);
		//Close site
		driver.close(); 
	}
}
