package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test110
{
	public static void main(String[] args) throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site 
		driver.get("https://semantic-ui.com/modules/checkbox.html");
		Thread.sleep(5000);
		//Collect all check boxes
		List<WebElement> l=driver.findElements(By.xpath("//input[@type='checkbox']"));
		//check each checkbox
		int x=0;
		int y=0;
		for(WebElement e:l)
		{
			if(e.isSelected())
			{
				x++;
			}
			else
			{
				y++;
			}
		}
		System.out.println("selected check boxes count is "+x);
		System.out.println("deselected check boxes count is "+y);
		//close site
		driver.close();
	}
}
