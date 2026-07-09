package practice;

import java.util.Set;

import org.openqa.selenium.ScriptKey;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test223
{
	@Test
	public void method() throws Exception
	{
		//Open browser and launch site
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://users.cs.cf.ac.uk/Dave.Marshall/Internet/FRAMES/nested_frame.html"); 
		Thread.sleep(5000);
		//1. write JavaScript statements to pin
		driver.pin("return(window.frames.length);");
		driver.pin("var frames=window.frames;");
		driver.pin("frames[3].location='https://www.bbc.com';");
		driver.pin("frames[5].location='https://www.google.com';");
		//2. get all pinned statements
		Set<ScriptKey> l1=driver.getPinnedScripts(); 
		//3. unpin 
		for(ScriptKey sk:l1)
		{
			driver.unpin(sk);
		}
		//Close site
		driver.close();
	}
}
