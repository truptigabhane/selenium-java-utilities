package mypack;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v118.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Dummy19 
{
    public static void main(String[] args) throws Exception
    {
    	WebDriverManager.chromedriver().setup();
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--log-level=1");
    	ChromeDriver driver = new ChromeDriver(options);
    	DevTools devTools = driver.getDevTools();
    	devTools.createSession();
    	devTools.send(Log.enable());
    	devTools.addListener(Log.entryAdded(),
    	                           logEntry -> {
    	                               System.out.println("log: "+logEntry.getText());
    	                               System.out.println("level: "+logEntry.getLevel());
    	                           });
    	driver.get("http://www.google.co.in");
    	Thread.sleep(5000);
    	WebElement e=driver.findElement(By.name("q"));
        JavascriptExecutor jsExecutor=(JavascriptExecutor) driver;
        jsExecutor.executeScript("console.dir(arguments[0]);",e);
        Thread.sleep(10000);
    	// Check the terminal output for the browser console messages.
    	
    }
}

