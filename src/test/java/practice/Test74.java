package practice;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test74
{
	public static void main(String[] args)
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver	driver=new ChromeDriver();
		Duration d=driver.manage().timeouts().getPageLoadTimeout();
        System.out.println(d.getSeconds()); //300seconds
		//Launch site
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(1835));
		driver.get("https://www.gmail.com");
        //close site
        driver.close();
	}
}
