package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test143 
{
	@Test
	public void method() throws Exception
	{
		//Open file with required permissions
		File f=new File("src\\test\\resources\\gmailuiddata.txt");
		FileReader fr=new FileReader(f);
		BufferedReader br=new BufferedReader(fr);
		//Data driven with Hard assertion
		String line="";
		while((line=br.readLine())!=null)
		{
			//Open browser and launch site
			WebDriverManager.chromedriver().setup();
			RemoteWebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.gmail.com");
			Thread.sleep(5000);
			//split line of data into pieces
			String data[]=line.split(",");
			//Parameterise code
			driver.findElement(By.name("identifier")).sendKeys(data[0]);
			driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
			Thread.sleep(5000);
			//validations or verifications or assertions
			try
			{
				if(data[1].equals("valid") && 
				driver.findElement(By.name("password")).isDisplayed())
				{
					Reporter.log("valid UID Test passed");
					Assert.assertTrue(true);
				}
				else if(data[1].equals("invalid") && driver.findElement(By.xpath(
						"//div[text()=\"Couldn’t find your Google Account\"]")).isDisplayed())
				{
					Reporter.log("Invalid UID Test passed");
					Assert.assertTrue(true);
				}
				else if(data[1].equals("blank") && driver.findElement(By.xpath(
						"//div[text()='Enter an email or phone number']")).isDisplayed())
				{
					Reporter.log("blank UID Test passed");
					Assert.assertTrue(true);		
				}
				else
				{
					Reporter.log(data[1]+" UID Test failed");
					//code for screenshot or video recording along with mail sending to manager
					Assert.assertTrue(false); 
				}
			}
			catch(Exception ex)
			{
				Reporter.log(data[1]+" UID Test failed");
				//code for screenshot or video recording along with mail sending to manager
				Assert.assertTrue(false); 
			}
			//close site
			driver.close();
		} //loop ending
		br.close();
		fr.close();
	}
}
