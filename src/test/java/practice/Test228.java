package practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v118.security.Security;
import org.testng.annotations.Test;

public class Test228
{
	@Test
	public void method() throws Exception
	{
		//Open browser
		ChromeDriver driver=new ChromeDriver();
		//Create DevTools session and activate Security panel
		DevTools dt=driver.getDevTools();
	    dt.createSession();
	    //set to ignore SSL certificate errors
	    Command cmd1=Security.enable();
	    Command cmd2=Security.setIgnoreCertificateErrors(true);
	    dt.send(cmd1);
	    dt.send(cmd2);
        //launch insecure web site
        driver.get("https://expired.badssl.com/");
	}
}
