package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test103
{
	public static void main(String[] args) throws Exception
	{
		//open browser(operation)
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site(operation)
		driver.get("https://www.google.co.in");
		Thread.sleep(5000);
		//1. Get text of visible element(developed with paired tag and it has some text)
		//Get corresponding text successfully
		String x=driver.findElement(By.xpath("//div[@id='gb']/descendant::a[1]"))
				                                                      .getText();
		System.out.println(x);
		//2. Get text of visible element(developed with paired tag but no text)
		//get a blank value, but no exception
		String y=driver.findElement(By.xpath("//div[@jsname='vdLsw']")).getText();
		System.out.println(y);
		//3. 2. Get text of visible element(developed with unpaired tag)
		//get a blank value, but no exception
		driver.navigate().to("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_hr_test");
		Thread.sleep(5000);
		driver.switchTo().frame("iframeResult");
		String z=driver.findElement(By.xpath(
			"//h1[text()='The Main Languages of the Web']/following-sibling::hr[1]")).getText();
		System.out.println(z);
		//close site
		driver.close();
	}
}
