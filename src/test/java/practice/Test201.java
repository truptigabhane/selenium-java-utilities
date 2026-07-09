package practice;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test201
{
	public static void main(String[] args) throws Exception
	{
		//Take value from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter password value");
		String x=sc.nextLine();
		sc.close();
		//Open browser and Launch site
		WebDriverManager.chromedriver().setup();    
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Step-1:locate password element and enter a value
		WebElement e=driver.findElement(By.name("pass"));
		e.sendKeys(x);
		Thread.sleep(5000);
		//Step-2: change password box type to "text" to get visibility of given value
		driver.executeScript("arguments[0].setAttribute('type','text');",e);
		Thread.sleep(5000); 
		//Step-3: get that visible value
		String y=e.getAttribute("value");
		//Step-4: compare that visible value with given value
		if(x.equals(y))
		{
			System.out.println("Password masking Test passed");
		}
		else
		{
			System.out.println("Test failed");
		}
		//close site
		driver.close();
	}
}






