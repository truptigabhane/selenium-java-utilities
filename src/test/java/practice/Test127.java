package practice;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test127
{
	SimpleDateFormat sf;
    Date dt;
    ATUTestRecorder recorder;
	RemoteWebDriver driver;
	
	@Test(priority=1)
	public void startRecording() throws Exception
	{
		//Start recording
		sf=new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
        dt=new Date();
        String vp="target\\"+sf.format(dt); //".mov" is default extension
        recorder=new ATUTestRecorder(vp,true); //false means no audio
        recorder.start();
	}
	@Test(priority=2)
	public void paginationTesting() throws Exception
	{
		//Open Chrome browser
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://www.flipkart.com");
		Thread.sleep(5000);
		//close banner if exists
		try
		{
			driver.findElement(By.xpath(
					"(//span[text()='Login'])[1]/preceding::button[1]")).click();
			Thread.sleep(5000);
		}
		catch(Exception ex)
		{
			System.out.println("No banner for this time");
		}
		//click on "mobiles" link
		driver.findElement(By.xpath("(//div[text()='Mobiles'])|(//a[@aria-label='More results'])")).click();
		Thread.sleep(5000);
		//click on "Shop Now" for 1st product
		driver.findElement(By.xpath("//p[text()='Realme']")).click();
		Thread.sleep(5000);
		//pagination
		int pno=1;
		while(true)
		{
			//goto next page if exists by clicking on Next link
			try
			{
				driver.findElement(By.xpath("//span[text()='Next']")).click();
				Thread.sleep(3000);
				pno++;
			}
			catch(Exception e)
			{
				break; //terminate from loop
			}
		}
		System.out.println(pno);
	}
	@Test(priority=3)
	public void closeSite() throws Exception
	{
		//close site
		driver.close();
	}
	@Test(priority=4)
	public void stopRecording() throws Exception
	{
		//stop recording
		recorder.stop();
	}
}
