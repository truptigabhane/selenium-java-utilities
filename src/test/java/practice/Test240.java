package practice;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test240
{
	public static void main(String[] args) throws Exception
	{
		//way-2 keyboard automation
		//Open browser and launch site
		WebDriverManager.firefoxdriver().setup();
		RemoteWebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.spicejet.com");
		//keyboard automation on screen
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
	}
}
