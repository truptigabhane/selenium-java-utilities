package practice;

import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2 
{
	public static void main(String[] args) throws InterruptedException
	{
		//Download gecko driver software
		WebDriverManager.firefoxdriver().setup();
		//open firefox browser using that browser driver software
		FirefoxDriver driver=new FirefoxDriver();
		//launch site
		driver.get("http://www.google.co.in");
		//wait few seconds
		Thread.sleep(5000);
		//close the browser window
		driver.close();
	}
}
