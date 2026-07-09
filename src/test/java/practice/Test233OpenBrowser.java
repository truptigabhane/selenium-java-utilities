package practice;

import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test233OpenBrowser
{
	public static void main(String[] args)
	{
		//Open browser
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in");
		//get browser capabilities in key value pairs
	    Capabilities c=driver.getCapabilities();
	    Map<String,Object> m=c.asMap();
	    m.forEach((key, value) -> 
	    {
	         System.out.println("Key is: " + key + " Value is: " + value);
	    });
	    //don't close browser
	    //copy "localhost:50839" like value in output
	    //Then goto next program
	}

}
