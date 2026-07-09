package practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test245
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and launch site
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		Thread.sleep(5000);
		//Automate Login pop-up using SikuliX
		ImagePath.add(System.getProperty("user.dir"));
		Screen s=new Screen();
		s.type("src\\test\\resources\\images\\username.png","admin");
		Thread.sleep(5000);
		s.type("src\\test\\resources\\images\\password.png","admin");
		Thread.sleep(5000);
		s.click("src\\test\\resources\\images\\signin.png");
	}
}






