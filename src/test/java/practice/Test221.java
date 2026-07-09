package practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test221
{
	@Test
	public void method() throws Exception
	{
		//Open chrome browser and Launch site
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//run javascript code asynchronously(irrespective of order of statements)
		driver.executeAsyncScript(
				 "window.setTimeout(function(){window.alert('hi kalam sir');},1000);"
				  +"window.alert('hi students');"
				  +"window.setTimeout(function(){window.alert('how are you?');},500);"
				 );
	}
}








