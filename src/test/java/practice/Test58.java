package practice;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test58
{
	public static void main(String[] args) throws Exception
	{
		//Take a word from keyword
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a word to search");
		String x=sc.nextLine();
		sc.close();
		//Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver(); 
		//Launch site
		driver.get("https://www.google.co.in");
		Thread.sleep(5000); 
		//Enter a value
		driver.findElement(By.name("q")).sendKeys(x);
		Thread.sleep(5000); 
		//Test cache items as per given value
		List<WebElement> suggestions=driver.findElements(By.xpath(
				                                 "(//ul[@role='listbox'])[1]/li"));
		int flag=0;
		for(WebElement suggestion:suggestions)
		{
			String y=suggestion.getText();
			y=y.toLowerCase();
			y=y.replace(" ","");
			x=x.toLowerCase();
			x=x.replace(" ","");
			if(!y.contains(x))
			{
				System.out.println(y);
				flag=1;
			}
		}
		if(flag==0)
		{
			System.out.println("All suggestions are correct");
		}
		else
		{
			System.out.println("All suggestions are not correct");
		}
		//close site
		driver.close();
	}
}





