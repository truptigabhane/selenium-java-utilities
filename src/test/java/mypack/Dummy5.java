package mypack;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Dummy5 
{
	public static void main(String[] args)
	{
		Object o;
		RemoteWebDriver driver1=new ChromeDriver();
		RemoteWebDriver driver2=new ChromeDriver();
		if(driver1==driver2) //compare memory addresses of 2 objects
		{
			System.out.println("same"); 
		}
		else
		{
			System.out.println("not same"); 
		}
		if(driver1.equals(driver2)) //compare memory addresses of 2 objects
		{
			System.out.println("same"); 
		}
		else
		{
			System.out.println("not same"); 
		}
	}
}
