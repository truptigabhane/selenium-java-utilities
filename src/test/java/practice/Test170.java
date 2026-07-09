package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test170 
{
	public static void main(String[] args) throws Exception
	{
		//1. Connect to DB as per DB technology used by DEV team
		Class.forName("com.mysql.jdbc.Driver"); //for MySQL server
		Connection con=DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/batch264","root","admin");
		//2. Get data from DB table using SQL query
		Statement st=con.createStatement();  
		ResultSet res=st.executeQuery("select * from search_words;");
		while(res.next()) //goto each row in result set
		{
			String value=res.getString(2); //take 2nd column(word) value in that row
			//launch site
			WebDriverManager.chromedriver().setup();
			RemoteWebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://www.google.co.in");
			Thread.sleep(5000);
			//data driven test
			driver.findElement(By.name("q")).sendKeys(value,Keys.ENTER);
			Thread.sleep(5000);
			if(driver.getTitle().contains(value))
			{
				System.out.println("Test passed for "+value);
			}
			else
			{
				System.out.println("Test failed for "+value);
			}
			//close site
			driver.close();
		}
		//disconnect from DB
		con.close();
	}
}
