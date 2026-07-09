package practice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test205
{
	public static void main(String[] args) throws Exception
	{
		//Web pages Content testing
		//Take two words/sentences from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a word/sentence to be searched");
		String x=sc.nextLine();
		System.out.println("enter a target word/sentence/regular epression");
		String y=sc.nextLine();
		sc.close();
		//Open browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site under testing(SUT)
		driver.get("http://www.google.co.in");
		Thread.sleep(5000); 
		//search a word
		driver.findElement(By.name("q")).sendKeys(x,Keys.ENTER);
		Thread.sleep(5000); 
		//Pagination on result pages
		int currentpageindex=1;
		int total=0;
		while(true) //infinite loop
		{
			try
			{
				//Step-1: get content(inner text) of current result page using JavaScript
				String z=(String) driver.executeScript(
						                 "return(document.documentElement.innerText);");
				//Step-2: search for target word in that content using Regexp
				Pattern p=Pattern.compile(y,Pattern.CASE_INSENSITIVE);
				Matcher m=p.matcher(z);
				//Step-3: Get count of target word's occurrences 
				int noow=0;
				while(m.find())
				{
					noow++;
				}
				//Step-4: add page level count to total count 
				total=total+noow;
				//Step-5: Display page level count
				System.out.println(currentpageindex+"th page consists of "+noow);
				//Step-6: Go to next page if exists
				driver.findElement(By.xpath("//a[text()='"+(currentpageindex+1)+"']")).click();
				Thread.sleep(2000); 
				currentpageindex++;
			}
			catch(Exception ex)
			{
				break; //terminate from current loop
			}
		}
		System.out.println("Total count of results is "+total);
		//close site
		driver.close();
	}
}
