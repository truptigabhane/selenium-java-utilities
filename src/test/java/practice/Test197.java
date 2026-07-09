package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test197
{
	@Test
	public void method() throws Exception
	{
		//Open browser and launch site
		WebDriverManager.chromedriver().setup();       
        RemoteWebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.co.in");
        Thread.sleep(5000);
        //way-1: both locate and operate element using JavaScript
        driver.executeScript("document.getElementsByName('q')[0].value='abdul kalam';");
        //way-2: locate element using SWD-java and operate that element using JavaScript
        WebElement e=driver.findElement(By.name("btnK"));
        driver.executeScript("arguments[0].click();",e);
	}
}







