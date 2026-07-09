package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test36
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver(); 
		//Launch site using base URL
		driver.get("https://www.flipkart.com");
		Thread.sleep(5000); 
		//Close banner if exists
		try
		{
			driver.findElement(By.xpath("//span[text()='Login']/preceding::button[1]")).click();
			Thread.sleep(5000); 
		}
		catch(Exception ex)
		{
			System.out.println("No banner this time");
		}
		//click on "beauty" link
		driver.findElement(By.xpath("//div[starts-with(text(),'Beauty')]")).click();
		Thread.sleep(5000); 
		//click on "VIEW ALL"
		driver.findElement(By.xpath("(//a[text()='VIEW ALL'])[1]")).click();
		Thread.sleep(5000);
		//click on cameras link
		driver.findElement(By.xpath("//div[text()='Top Mirrorless Cameras']")).click();
		Thread.sleep(5000);
		//collect all camera models
		List<WebElement> all=driver.findElements(
				By.xpath("//div[text()='Newest First']/following::a[@class='_1fQZEK']"));
		for(int i=0;i<all.size();i++)
		{
			all.get(i).click();
			Thread.sleep(5000);
			//switch to newly opened window/tab(2nd tab)
			Set<String> s=driver.getWindowHandles();
			List<String> l=new ArrayList<String>(s);
			driver.switchTo().window(l.get(1));
			//get amount and display
			String x=driver.findElement(By.xpath(
			  "//div[@id='price-info-icon']/preceding::div[@class='_30jeq3 _16Jk6d']")).getText();
			x=x.substring(1); //take text from 2nd position to avoid currency symbol
			x=x.replace(",",""); //remove , in value
			System.out.println(x);
			//close that browser windows/tab
			driver.close();
			//back to previous page
			driver.switchTo().window(l.get(0));
			Thread.sleep(2000);
		}
		//close site
		//driver.close();
	}
}
