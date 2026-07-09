package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test34 
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser using chromedriver software
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://selectorshub.com/shadow-dom-in-iframe/");
		Thread.sleep(5000);
		//switch to frame
		driver.switchTo().frame("pact");
		//target Element is inside single shadow DOM
		WebElement shadowHostElement=driver.findElement(By.id("snacktime"));
		SearchContext shadowRootElement=shadowHostElement.getShadowRoot();
		WebElement targetElement=shadowRootElement.findElement(By.className("food"));
		try
        {
            targetElement.click();
            Thread.sleep(5000);
        }
        catch(JavascriptException ex)
        {
            driver.executeScript("arguments[0].click();", targetElement);
            Thread.sleep(5000);
        }
		//switch to newly opened window/tab
		Set<String> s=driver.getWindowHandles();
        List<String> l=new ArrayList<String>(s);
        driver.switchTo().window(l.get(1));
        driver.findElement(By.xpath("//li[@id='menu-item-48']/a")).click();
	}
}
