package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test246
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and launch site
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_file");
		Thread.sleep(5000);
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("(//*[@type='file'])[1]"))
		         .sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\tulips.jpg");
	}
}
