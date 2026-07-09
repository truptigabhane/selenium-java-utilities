package practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test251_1
{
	public static void main(String[] args) 
	{
		//Open chrome browser 
		ChromeOptions co=new ChromeOptions();
		String[] s=new String[]{"enable-automation"};
		co.setExperimentalOption("excludeSwitches",s);
		ChromeDriver driver=new ChromeDriver(co);
		driver.manage().window().maximize();
	}
}
