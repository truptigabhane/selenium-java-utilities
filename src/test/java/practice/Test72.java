package practice;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test72
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver(); //browser open in normal size
		Thread.sleep(3000);
		//Minimize browser
		driver.manage().window().minimize();
		Thread.sleep(3000);
		//Maximize browser
		driver.manage().window().maximize(); //Maximise with tool bars
		Thread.sleep(3000);
		//get current size
		int w=driver.manage().window().getSize().getWidth();
		int h=driver.manage().window().getSize().getHeight();
		System.out.println(w+" "+h);
		//Resize browser
		Dimension d=new Dimension(800,300); //width and height
		driver.manage().window().setSize(d);
		Thread.sleep(5000);
		//get current position 
		int x=driver.manage().window().getPosition().getX();
		int y=driver.manage().window().getPosition().getY();
		System.out.println(x+" "+y);
		//Relocate browser on Desktop
		Point p=new Point(200,200); //x and y coordinates
		driver.manage().window().setPosition(p);
		Thread.sleep(5000);
		//get full screen
		driver.manage().window().fullscreen(); //Maximise without tool bars
		Thread.sleep(5000);
		//Back to normal(core Java)
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(5000);	
	}
}
