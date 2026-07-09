package practice;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test39
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser using chromedriver software 
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//launch site
		driver.get("http://www.facebook.com");
		Thread.sleep(5000);
		//Fill active element(EmailId)
		driver.switchTo().activeElement().sendKeys("abdulkalam",Keys.TAB);
		Thread.sleep(5000);
		//Fill active element(Password)
		driver.switchTo().activeElement().sendKeys("batch264",Keys.TAB, Keys.TAB);
		Thread.sleep(5000);
		//Click on active element
		driver.switchTo().activeElement().click();
	}
}

