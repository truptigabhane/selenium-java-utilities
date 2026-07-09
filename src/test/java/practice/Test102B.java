package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test102B
{
	public static void main(String[] args) throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site(operation)
		driver.get("https://www.w3schools.com/css/tryit.asp?filename=trycss_before");
		Thread.sleep(5000);
		driver.switchTo().frame("iframeResult");
		//Locate element
		WebElement e=driver.findElement(By.xpath("(//h1[text()='This is a heading'])[1]"));
		String x=(String) driver.executeScript(
				"var ps=window.getComputedStyle(arguments[0],'::before');" + 
				"var s=ps.getPropertyValue('content');" + 
				"return(s);",e);
		System.out.println(x);
		driver.switchTo().defaultContent();
		//close site
		driver.close();
	}
}