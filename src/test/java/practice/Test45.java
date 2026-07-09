package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test45
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
		System.out.println("Count of tables is "+tables.size());
		//Highlight each visible table with a border
		for(WebElement table:tables)
		{
			if(table.isDisplayed())
			{
				driver.executeScript("arguments[0].style.border='2px dotted yellow';",table);
			}
		}
		//collect rows in each table
		for(WebElement table:tables)
		{
			List<WebElement> rows=table.findElements(By.xpath("child::tr"));
			System.out.println("Count of rows is "+rows.size());
			//collect all cols in each row
			for(WebElement row:rows)
			{
				List<WebElement> cols=row.findElements(By.xpath("child::td"));
				System.out.println("Count of cols is "+cols.size());
				//Goto each col to get value
				for(WebElement col:cols)
				{
					System.out.print(col.getText()+", ");
				}
				System.out.println();
			}
		}
		//close site
		driver.close();
	}
}