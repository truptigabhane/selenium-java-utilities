package practice;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v118.network.Network;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;

public class Test226
{
	@Test
	public void method() throws Exception
	{
		//Open browser 
		ChromeDriver driver=new ChromeDriver();
		//Create DevTools session 
		DevTools dt=driver.getDevTools();
		dt.createSession();
		//Set blocked URL patterns
		Command cmd1=Network.enable(Optional.empty(),Optional.empty(),Optional.empty());
		Command cmd2=Network.setBlockedURLs(ImmutableList.of("*.png","*.gif"));
		dt.send(cmd1);
		dt.send(cmd2);
		//Launch site
		driver.get("https://www.redbus.in");
		Thread.sleep(5000);
		//driver.close();
	}
}
