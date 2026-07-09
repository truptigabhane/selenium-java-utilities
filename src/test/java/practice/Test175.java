package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test175
{
	public static void main(String[] args)
	{
		//Open browser, define wait and launch site
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver();
		FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(100));
		driver.manage().window().maximize();
		driver.get("http://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/"
				                                      +"explicit-show-hide/defaultcs.aspx"); 
		//Define wait condition for calendar
		wait.until(visibilityOfElementLocated(
                                        By.xpath("//*[contains(@class,'RadCalendar')]")));
		//Get calendar in to top of desktop
		WebElement e=driver.findElement(By.xpath("//*[contains(@class,'RadCalendar')]"));
		driver.executeScript("arguments[0].scrollIntoView();",e);
		//wait, locate and click on a day link
		wait.until(elementToBeClickable(By.linkText("22"))).click();
		//Define wait condition for invisibility of loader(Spinner) icon
		wait.until(invisibilityOfElementLocated(By.className("raDiv")));
		//close site
		driver.close();
	}
}
