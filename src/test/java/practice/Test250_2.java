package practice;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test250_2
{
	public static void main(String[] args) throws Exception
	{
		//Create an empty folder if not exists
		File fo=new File("src\\test\\resources\\downloads");
		fo.mkdir(); 
		//Define arguments/preferences for firefox browser
		FirefoxProfile profile=new FirefoxProfile();
		//Set previously created folder path to store file to be downloaded
		profile.setPreference("browser.download.dir",fo.getAbsolutePath());
		//1 means downloads folder, 2 means given folder
		profile.setPreference("browser.download.folderList",2); 
		//Stop pop-up windows which are emulating file download 
		profile.setPreference("browser.download.manager.showWhenStarting",false);
		profile.setPreference("pdfjs.disabled",true);
		//Set MIME types w.r.t type of file to be downloaded(ex: jar file) 
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				                                           "application/java-archive");
		FirefoxOptions ffo=new FirefoxOptions();
		ffo.setProfile(profile);
		//Open browser
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver=new FirefoxDriver(ffo); 
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Launch site
		driver.get("https://selenium.dev/");
		driver.findElement(By.xpath("//*[text()='Downloads']")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("4.8.0")).click();
		Thread.sleep(2000);
		//Handle download window
		Screen s=new Screen();
		s.click("src\\test\\resources\\images\\savefile.png");
		Thread.sleep(20000); //wait for complete downloading
	}
}
