package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Test203
{
	public static void main(String[] args) throws Exception
	{
		//open browser and launch site(SWD)
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in"); 
		Thread.sleep(5000);
		//Locate an element and get text of that element including child elements
		WebElement e=driver.findElement(By.id("SIvCob"));
		String x=e.getText();
		System.out.println(x); 
		//get text of that element only(not from child elements)
		String y=(String) driver.executeScript(
				           "return(arguments[0].childNodes[0].textContent);",e);
		System.out.println(y); 
		//close site
		driver.close();
	}
}
