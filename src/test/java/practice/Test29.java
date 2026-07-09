package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test29
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://chercher.tech/practice/frames");
		Thread.sleep(5000);
		//fill text box 
		driver.switchTo().frame(0); //1st frame in page
		driver.findElement(By.xpath(
			"//b[@id='topic']/following-sibling::input")).sendKeys("abdul kalam sir");
		//select check box 
		driver.switchTo().frame(0); //1st inner frame in 1st frame in page
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		//back to page directly from inner frame
		driver.switchTo().defaultContent();
	}
}






