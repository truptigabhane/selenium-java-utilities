package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test210
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and Launch site
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
	driver.get("https://stackoverflow.com/questions/38653910/actions-click-script-selenium");
		Thread.sleep(5000);
		//Page scroll down to get visibility of element
		Actions act=new Actions(driver);
		for(int i=1;i<=10;i++)
		{
			act.sendKeys(Keys.ARROW_DOWN).perform();
			Thread.sleep(1000);
		}
		//Element scroll down
		WebElement e=driver.findElement(By.xpath("(//pre[contains(@class,'lang-java')])[1]"));
		for(int i=1;i<=10;i++)
		{
			act.sendKeys(e,Keys.ARROW_DOWN).perform();
			Thread.sleep(1000);
		}
		//Element scroll top
		for(int i=1;i<=10;i++)
		{
			act.sendKeys(e,Keys.ARROW_UP).perform();
			Thread.sleep(1000);
		}
		//Element scroll right
		for(int i=1;i<=10;i++)
		{
			act.sendKeys(e,Keys.ARROW_RIGHT).perform();
			Thread.sleep(1000);
		}
		//Element scroll left
		for(int i=1;i<=10;i++)
		{
			act.sendKeys(e,Keys.ARROW_LEFT).perform();
			Thread.sleep(1000);
		}
		//close site
		driver.close();
	}
}
