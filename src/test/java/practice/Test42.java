package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test42 
{
	public static void main(String[] args) throws Exception
	{
		//open chrome browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch fast mail site
		driver.get("http://www.fastmail.com");
		Thread.sleep(5000);
		//do login
		driver.findElement(By.xpath("//strong[text()='Log in']/parent::a")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("username")).sendKeys("magnitiait");
		driver.findElement(By.name("password")).sendKeys("Magnitia@264");
		driver.findElement(By.xpath("//span[text()='Log in']/parent::button")).click();
		Thread.sleep(5000);
		//click on compose
		driver.findElement(By.xpath("//a[contains(@class,'new-message')]")).click();
		Thread.sleep(5000);
		
		
	}
}
