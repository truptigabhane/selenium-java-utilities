package practice;

import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test188Solution
{
	public static void main(String[] args) throws Exception
	{
		//Drag and Drop between two elements in two different frames
		//Setting up chrome driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Redirecting to the web site
		driver.get("https://codepen.io/rjsmer/full/vvewWp");
		Thread.sleep(5000);
		//Via Mouse Automation on Desktop
		Robot robot=new Robot();
		robot.mouseMove(120, 300);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		robot.mouseMove(500, 320);
		Thread.sleep(2000);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
}
