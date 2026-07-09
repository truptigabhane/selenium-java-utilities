package practice;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test206
{
	public static void main(String[] args)throws Exception
	{
		//Page scrolling(top to bottom and bottom to top)
		//Open browser and launch site
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
	driver.get("https://stackoverflow.com/questions/38653910/actions-click-script-selenium");
		Thread.sleep(5000);
		//Page Down
		Actions a=new Actions(driver);
		a.sendKeys(Keys.END).perform();
		Thread.sleep(5000);
		//Page Up
		a.sendKeys(Keys.HOME).perform();
		Thread.sleep(5000);
	}
}
