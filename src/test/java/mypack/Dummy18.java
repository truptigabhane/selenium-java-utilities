package mypack;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v118.console.Console;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Dummy18 
{
    public static void main(String[] args) throws Exception
    {
    	WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        // Enable the Console domain to capture console logs
        devTools.send(Console.enable());
        driver.get("http://www.google.com");
        Thread.sleep(5000);
        WebElement e=driver.findElement(By.name("q"));
        JavascriptExecutor jsExecutor=(JavascriptExecutor) driver;
        jsExecutor.executeScript("console.dir(arguments[0]);",e);
        Thread.sleep(10000);
        Object consoleLogs = jsExecutor.executeScript("var consoleLogs = [];" 
        		+             "var originalConsoleLog = console.log;"
        		+             "console.log = function(message) {" 
        		+             "    consoleLogs.push(message);" 
        		+             "    originalConsoleLog.apply(console, arguments);" 
        		+             "};"
        		+             "return consoleLogs;");
        Thread.sleep(5000);
        if (consoleLogs instanceof java.util.List<?>) 
        {
            for (Object log : (java.util.List<?>) consoleLogs) 
            {
                System.out.println("Console Log: " + log.toString());
            }
        }
    }
}

