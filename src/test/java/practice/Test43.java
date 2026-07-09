package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test43
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver(); 
		//Launch google
		driver.get("https://www.amazon.com");
		Thread.sleep(5000); 
		//collect all elements in page source
		List<WebElement> l=driver.findElements(By.xpath("//*"));
		System.out.println("All elements count is "+l.size());
		int vec=0;
		int iec=0;
		for(WebElement e:l)
		{
			if(e.isDisplayed())
			{
				vec=vec+1;
				driver.executeScript("arguments[0].style.border='2px dotted yellow';",e);
			}
			else
			{
				iec=iec+1;
			}
		}
		System.out.println("Visible elements count is "+vec);
		System.out.println("Invisible(hidden) elements count is "+iec);
		//close site
		//driver.close();
	}
}





