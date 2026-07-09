package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test209
{
	public static void main(String[] args) throws Exception
	{
		//Element scrolling(top to bottom and bottom to top)
		//Open chrome browser
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
	driver.get("https://stackoverflow.com/questions/38653910/actions-click-script-selenium");
		Thread.sleep(5000);
		//Element Down
		Actions a=new Actions(driver);
		WebElement e=driver.findElement(By.xpath("(//pre[contains(@class,'lang-java')])[1]"));
		a.sendKeys(e,Keys.END).perform();
		Thread.sleep(5000);
		//Element Up
		a.sendKeys(e,Keys.HOME).perform();
		Thread.sleep(5000);
	}
}









