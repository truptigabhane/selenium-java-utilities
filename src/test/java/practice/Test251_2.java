package practice;

import java.util.Iterator;

import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test251_2
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser 
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Screen s=new Screen();
		Iterator<Match> l=s.findAll("src\\test\\resources\\images\\close.png");
		Match e=l.next(); //1st matched element
		e.click(); // close button is not working in that dialog
		
	}
}
