package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test190
{
	public static void main(String[] args) throws Exception
	{
		//Multi-select drop down developed using <select> tag
		//Open browser
		WebDriverManager.chromedriver().setup(); 
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(1000));
		//Launch site
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		//Automate <select> tag drop-down
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iframeResult"));
		WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("cars")));
		Select s=new Select(e);
		//Test case-1: is it multi-select or not?
		if(s.isMultiple())
		{
			System.out.println("Multi-select drop down");
		}
		else
		{
			System.out.println("Single-select drop down");
		}
		//Test case-2: get all items and display
		List<WebElement> l=s.getOptions();
		System.out.println("Count of all items in drop down is "+l.size());
		System.out.println("All items are:");
		System.out.println("---------------");
		for(WebElement i:l)
		{
			System.out.println(i.getText());
		}
		//Test case-3: select multiple items one by one
		Actions act=new Actions(driver);
		if(System.getProperty("os.name").contains("Win"))
		{
			act.keyDown(Keys.CONTROL)
			.click(s.getOptions().get(3)).pause(3000)
			.click(s.getOptions().get(1)).pause(3000)
			.click(s.getOptions().get(0)).pause(3000)
			.click(s.getOptions().get(2)).pause(3000)
			.keyUp(Keys.CONTROL).build().perform();
		}
		else if(System.getProperty("os.name").contains("Mac"))
		{
			act.keyDown(Keys.COMMAND)
			.click(s.getOptions().get(3)).pause(3000)
			.click(s.getOptions().get(1)).pause(3000)
			.click(s.getOptions().get(0)).pause(3000)
			.click(s.getOptions().get(2)).pause(3000)
			.keyUp(Keys.COMMAND).build().perform();
		}
		else
		{
			System.out.println("Unknown platform");
			System.exit(0);
		}
		//Test case-4: 
		String x=s.getFirstSelectedOption().getText();
		System.out.println("First item in selected items:");
		System.out.println("----------------------------");
		System.out.println(x);
		//Test case-5: get all selected items
		List<WebElement> y=s.getAllSelectedOptions();
		System.out.println("All selected items:");
		System.out.println("-------------------");
		for(WebElement i:y)
		{
			System.out.println(i.getText());
		}
		//Test case-5: deselect items
		s.deselectByVisibleText("Audi");
		Thread.sleep(5000);
		s.deselectByIndex(1); //2nd item
		Thread.sleep(5000);
		s.deselectByValue("opel"); //value in source code
		Thread.sleep(5000);
		s.deselectAll();
		//close site
		//driver.close();
	}
}





