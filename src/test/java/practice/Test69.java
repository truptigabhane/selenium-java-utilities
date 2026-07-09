package practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test69
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver(); 
		//Launch site using base URL
		long st=System.currentTimeMillis();
		driver.get("https://www.google.co.in"); 
		long et=System.currentTimeMillis();
		System.out.println(et-st);
	}
}






