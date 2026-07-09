package practice;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test212
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser and launch site
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev");
		Thread.sleep(5000);
		//Zoom in(using JavaScript)
		driver.executeScript("document.body.style.zoom='200%';");
		Thread.sleep(5000);
		//Zoom out(using JavaScript)
		driver.executeScript("document.body.style.zoom='100%';");
		Thread.sleep(5000);
	}
}
