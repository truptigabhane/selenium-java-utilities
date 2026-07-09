package practice;

import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test216
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and launch site
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		Thread.sleep(5000);
		//Goto another site
		driver.navigate().to("https://www.yahoo.com");
		Thread.sleep(5000);
		//Goto another site
		driver.executeScript("window.location='https://www.magnitia.com';");
	}
}
