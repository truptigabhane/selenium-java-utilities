package practice;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test247
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
		//Automate File upload window via keyboard automation
		StringSelection x=new StringSelection("C:\\Users\\Public\\Pictures\\Sample Pictures\\tulips.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(x,null);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
}
