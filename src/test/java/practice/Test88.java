package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test88
{
	public static void main(String[] args) throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site 
		driver.get("http://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/"
				   +"explicit-show-hide/defaultcs.aspx");
		Thread.sleep(5000); 
		//Challenge-3: our target element is covered by another element like banner.
		//So, target element is not clickable and we get "ElementClickInterceptedException"
		driver.findElement(By.linkText("1")).click();
	}
}
