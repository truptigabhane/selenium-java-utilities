package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.WebTableUtility;

public class Test68 
{
	public static void main(String[] args) throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://www.espncricinfo.com/series/india-in-west-indies-2023-1381201/"
				+ "west-indies-vs-india-1st-test-1381212/full-scorecard");
		Thread.sleep(5000); 
		//work with a table
		WebElement wt=driver.findElement(By.xpath(
		                        "(//table[contains(@class,'ci-scorecard-table')])[2]"));
		//create an object utility class
		WebTableUtility obj=new WebTableUtility();
		int nor=obj.getRowsCount(wt);
		System.out.println(nor);
		//get bats man score details only(don't want extras, total,...) 
		for(int i=1; i<=nor-4; i++)
		{
			try
			{
				List<WebElement> batter=obj.getCellChilds(wt, i, 1, By.xpath("child::a"));
				String name=(String)driver.executeScript(
					                "return(arguments[0].textContent);",batter.get(0));
				String desc=obj.getCellValue(driver, wt, i, 2);
				String x=obj.getCellValue(driver, wt, i, 3);
				String y=obj.getCellValue(driver, wt, i, 4);
				String z=obj.getCellValue(driver, wt, i, 5);
				String w=obj.getCellValue(driver, wt, i, 6);
				String u=obj.getCellValue(driver, wt, i, 7);
				String v=obj.getCellValue(driver, wt, i, 8);
				System.out.println(name+"--"+desc+"--"+x+"--"+y+"--"+z+"--"+w+"--"+u+"--"+v);
			}
			catch(Exception ex)
			{
			}
		}
		//Close site
		driver.close();
	}
}
