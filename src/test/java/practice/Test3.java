package practice;

import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test3 
{
	public static void main(String[] args) throws InterruptedException
	{
		//Download msedge driver software
		WebDriverManager.edgedriver().setup();
		//open edge browser using that browser driver software
		EdgeDriver driver=new EdgeDriver();
		//launch site
		driver.get("http://www.google.co.in");
		//wait few seconds
		Thread.sleep(5000);
		//close the browser window
		driver.close();
	}
}
