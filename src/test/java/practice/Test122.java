package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test122
{
	@Test
	public void method() throws Exception
	{
		//open chrome browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		//Do login
		driver.findElement(By.name("identifier")).sendKeys("magnitiait");
		driver.findElement(By.xpath("//*[text()='Next']/parent::button")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("Passwd")).sendKeys("Magnitia@262");
		driver.findElement(By.xpath("//*[text()='Next']/parent::button")).click();
		Thread.sleep(10000);
		//way-1: locate target element directly
		WebElement e1=driver.findElement(By.xpath("(//table)[6]/tbody/tr[1]/td[4]/div[1]"));
		String o1=(String) driver.executeScript("return(arguments[0].textContent);",e1);
		System.out.println(o1);
		//way-2: locate target element hierarchically
		WebElement e2=driver.findElement(By.xpath("(//table)[6]/tbody"))
				            .findElement(By.xpath("child::tr[1]")) //1st mail
				            .findElement(By.xpath("child::td[4]"))
						    .findElement(By.xpath("child::div[1]"));
		String o2=(String) driver.executeScript("return(arguments[0].textContent);",e2);
		System.out.println(o2);
		String x[]=o2.split(",");
		System.out.println(x[0].trim()); //read/unread
		System.out.println(x[1].trim()); //"from" address
		System.out.println(x[2].trim()); //subject
		System.out.println(x[3].trim()); //attachment
		System.out.println(x[4].trim()); //Received date and time
		System.out.println(x[5].trim()); //mail body
		//Close site
		driver.close();
	}
}
