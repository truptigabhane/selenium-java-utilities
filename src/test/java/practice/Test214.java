package practice;

import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test214
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("http://www.gmail.com"); 
		Thread.sleep(5000);
		//Do some operations
		//------------
		//clear history
		driver.executeScript("history.go(0);");	//0 means forcibly clean
	}
}
