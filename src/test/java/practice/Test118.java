package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test118
{
	public static void main(String[] args) throws Exception
	{
		//open chrome browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		//Locate element and get attribute value and property value
		WebElement e=driver.findElement(By.name("q"));
		System.out.println(e.getAttribute("maxlength")); //HTML attribute
		System.out.println(e.getAttribute("clientHeight")); //HTML property
		//get value of an attribute of element given by developer in page source only
		System.out.println(e.getDomAttribute("maxlength")); //HTML attribute
		//get value of a property of element added by browser only
		System.out.println(e.getDomProperty("clientHeight")); //HTML property
        //get liast of all properties and attributes
		driver.executeScript("console.dir(arguments[0])", e);

        // Retrieve browser console logs
        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);

        // Iterate through logs to find console messages
        for (LogEntry entry : logs) {
            if (entry.getMessage().contains("CONSOLE")) {
                System.out.println("Console Output: " + entry.getMessage());
            }
        }
		//Close site
		driver.close();

	}

}
