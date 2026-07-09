package practice;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test239
{
	public static void main(String[] args)
	{
		//way-1: code bypassing
		//Open browser and launch site
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions fo=new FirefoxOptions();
		fo.addPreference("dom.webnotifications.enabled",false); //firefox native command as arg
		FirefoxDriver driver=new FirefoxDriver(fo);
		driver.manage().window().maximize();
		driver.get("http://www.spicejet.com");
	}
}
