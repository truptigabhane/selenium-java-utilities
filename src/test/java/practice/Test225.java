package practice;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v116.network.Network;
import org.openqa.selenium.devtools.v116.network.model.ConnectionType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test225
{
	@Test
	public void method() throws Exception
	{
		//Open browser via browser driver software
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Create DevTools session 
		DevTools dt=((ChromiumDriver) driver).getDevTools();
		dt.createSession();
		//Define expected Network conditions
		Command cmd1=Network.enable(
				            Optional.of(10000000),Optional.empty(),Optional.empty());
		Command cmd2=Network.emulateNetworkConditions(
				  false,100,200000,100000,Optional.of(ConnectionType.WIFI));
		dt.send(cmd1);
		dt.send(cmd2); 
		//Calculate elapsed time
		long st=System.currentTimeMillis();
	    driver.get("http://www.redbus.in");
	    long et=System.currentTimeMillis();
	    System.out.println("Load time is "+(et-st)+" msec");
	    driver.close();
	}
}
