package practice;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Test9 
{
	public static void main(String[] args) throws Exception
	{
		//open chrome browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.amazon.com");
		Thread.sleep(5000);
		//get title
		String x=driver.getTitle();
		System.out.println(x);
		//close site
		driver.close();
	}
}
