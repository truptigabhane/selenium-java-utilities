package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test215
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and launch site
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver"); 
		Thread.sleep(5000);
		//get frames count using SWD
		List<WebElement> l=driver.findElements(By.tagName("iframe"));
		System.out.println(l.size());
		//get frames count using JS
		long n=(long) driver.executeScript("return(window.frames.length);");
		System.out.println(n);
		//Close site
		driver.close();
	}
}
