package practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 
{
	public static void main(String[] args) throws InterruptedException
	{
		//Download latest chrome driver software(WDM)
		WebDriverManager.chromedriver().setup();
		//open chrome browser using that browser driver software(SWD)
		RemoteWebDriver driver=new ChromeDriver(); //up-casting
		//launch site(SWD)
		driver.get("http://www.google.co.in"); //dynamic binding
		//wait few seconds(JDK)
		Thread.sleep(5000);
		//close the browser window(SWD)
		//driver.close();
	}
}
