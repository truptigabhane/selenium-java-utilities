package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test213
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser 
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.executeScript("window.alert('site is ready to launch');");
		Thread.sleep(5000);
		driver.switchTo().alert().dismiss();
		driver.get("https://www.google.co.in");
		//search a word
		driver.executeScript("window.alert('going to search a word');");
		Thread.sleep(5000);
		driver.switchTo().alert().dismiss();
		driver.findElement(By.name("q")).sendKeys("Abdul kalam",Keys.ENTER);
		//close site
		driver.executeScript("window.alert('site is going to close');");
		Thread.sleep(5000);
		driver.switchTo().alert().dismiss();
		driver.close();
	}
}
