package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test44
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver(); 
		//Launch google
		driver.get("https://www.google.co.in");
		Thread.sleep(5000); 
		//get all hyper links
		List<WebElement> le=driver.findElements(By.tagName("a"));
		System.out.println(le.size());
		int vec=0;
		int iec=0;
		for(WebElement e:le)
		{
			if(e.isDisplayed())
			{
				vec=vec+1;
				driver.executeScript("arguments[0].style.border='5px dotted yellow';",e);
			}
			else
			{
				iec=iec+1;
			}
		}
		System.out.println("Visible links count is "+vec);
		System.out.println("Invisible(hidden) links count is "+iec);
		//close site
		//driver.close();
	}
}