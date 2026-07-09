package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test55
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver(); 
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		Thread.sleep(5000); 
		//collect all drop downs
		List<WebElement> l=driver.findElements(By.xpath(
                "//div[@class='ui active tab']/div/div[contains(@class,'dropdown')]"));
		//Open 3rd drop down
		l.get(2).click(); 
		Thread.sleep(5000); 
		//Select an 2nd item 
		l.get(2).findElement(By.xpath("child::div[contains(@class,'menu')]/div[2]")).click();
		Thread.sleep(5000); 
		//Open 4th drop down
		l.get(3).click(); 
		Thread.sleep(5000); 
		//Select an 6th item 
		l.get(3).findElement(By.xpath("child::div[contains(@class,'menu')]/div[6]")).click();
		//close site
		//driver.close();
	}
}





