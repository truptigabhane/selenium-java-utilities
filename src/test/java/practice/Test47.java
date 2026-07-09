package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test47
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver(); 
		driver.manage().window().maximize();
		//Launch google
		driver.get("https://www.espncricinfo.com/series/icc-men-s-t20-world-cup-2022-23-1298134/points-table-standings");
		Thread.sleep(5000); 
		//collect all tables in page source
		List<WebElement> tables=driver.findElements(By.xpath("//table/tbody"));
		System.out.println(tables.size());
		//collect all rows(visible and hidden) in each table
		for(int i=1;i<=tables.size();i++)
		{
			List<WebElement> rows=driver.findElements(By.xpath("(//table/tbody)["+i+"]/tr"));
			System.out.println(rows.size()+" rows in table-"+i);
			System.out.println("---------------");
			//collect all cols in each row
			for(int j=1;j<=rows.size();j++)
			{
				List<WebElement> cols=driver.findElements(
						By.xpath("(//table/tbody)["+i+"]/tr["+j+"]/td"));
				System.out.println(cols.size()+" cols in row-"+j);
				System.out.println("---------------");
				//Goto each col to get value
				for(int k=1;k<=cols.size();k++)
				{
					System.out.print(driver.findElement(
						By.xpath("(//table/tbody)["+i+"]/tr["+j+"]/td["+k+"]")).getText()+", ");
				}
				System.out.println();
			}
		}
		//close site
		driver.close();
	}
}