package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test202
{
	public static void main(String[] args) throws Exception
	{
		//open browser and launch site(SWD)
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://semantic-ui.com/modules/dropdown.html"); 
		Thread.sleep(5000);
		//Locate hidden element and get text(Using JavaScript)
		WebElement he=driver.findElement(By.xpath(
				                "(//div[text()='Gender']/following-sibling::div/div)[1]"));
		String x=he.getText();
		System.out.println(x); //null value
		String y=(String) driver.executeScript("return(arguments[0].textContent);",he);
		System.out.println(y); //original value
	}
}
