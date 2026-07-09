package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test248
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
		Actions act=new Actions(driver);
		WebElement e=driver.findElement(By.xpath("(//*[@type='file'])[1]"));
		act.moveToElement(e).moveByOffset(-10,0).click().build().perform();
		Thread.sleep(5000);
		//Automate file upload window
		Screen s=new Screen();
		s.type("src\\test\\resources\\images\\filename.png","C:\\Users\\Hp\\Pictures\\Charminar-Feature.jpg");
		Thread.sleep(5000);
		s.click("src\\test\\resources\\images\\open.png");
	}
}
