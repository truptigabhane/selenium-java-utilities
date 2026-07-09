package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test54
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver(); 
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://www.fastmail.com");
		Thread.sleep(5000); 
		//Do login
		driver.findElement(By.xpath("//strong[text()='Log in']/parent::a")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("username")).sendKeys("magnitiait");
		driver.findElement(By.name("password")).sendKeys("Magnitia@264");
		driver.findElement(By.xpath("//span[text()='Log in']/parent::button")).click();
		Thread.sleep(5000);
		//click on compose
		driver.findElement(By.xpath("//a[contains(@class,'new-message')]")).click();
		Thread.sleep(5000);
		//Collect all text boxes
		List<WebElement> l1=driver.findElements(By.xpath(
				"(//input[@type='text'])|(//textarea)|(//div[@role='textbox'])"));
		System.out.println("Count of text boxes is "+l1.size());
		int vtb=0;
		int htb=0;
		for(WebElement ele:l1)
		{
			if(ele.isDisplayed())
			{
				vtb++;
			}
			else
			{
				htb++;
			}
		}
		System.out.println("Count of visible text boxes is "+vtb);
		System.out.println("Count of hidden text boxes is "+htb);
		//do logout
		
		//close site
		driver.close();
	}
}





