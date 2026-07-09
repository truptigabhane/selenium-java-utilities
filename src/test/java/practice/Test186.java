package practice;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ActionsUtility;

public class Test186
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		WebDriverManager.chromedriver().setup(); 
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(1000));
		//Launch site
		driver.get("https://www.w3schools.com/css/css_tooltip.asp");
        ActionsUtility obj=new ActionsUtility(driver,wait);
        WebElement e1=
        		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("BOOTSTRAP")));
		System.out.println(obj.getStaticToolTipText(e1));
		WebElement e2=wait.until(ExpectedConditions.elementToBeClickable(
				                                   By.xpath("//div[contains(text(),'Top')]")));
		System.out.println(obj.getDynamicToolTipText(e2));
		//close site
		driver.close();
	}
}





