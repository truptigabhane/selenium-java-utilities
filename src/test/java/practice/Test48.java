package practice;

import java.io.BufferedInputStream;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test48
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver(); 
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://www.amazon.com");
		Thread.sleep(5000); 
		//create a new folder if not exists
		File folder=new File("E:\\batch264images");
        if(!folder.exists()) 
        {
        	folder.mkdirs();
        }
		//collect all images in page source
		List<WebElement> images=driver.findElements(By.xpath("//img"));
		System.out.println(images.size());
		int count=1;
		for(WebElement image:images)
		{
			try
			{
				//Take image's "src" value
				String imageUrl=image.getAttribute("src");
				String fileName="image"+count+".png";
				Path destinationPath=Path.of(folder.getAbsolutePath(),fileName);
				//Contact that "src" url to download image
				URL url=new URL(imageUrl);
				BufferedInputStream in=new BufferedInputStream(url.openStream()); 
				//Save that downloaded image in to our folder
				Files.copy(in, destinationPath, StandardCopyOption.REPLACE_EXISTING);
				//Close the streams
				in.close();
				count++; //increase count for next image
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
		}
		//close site
		driver.close();
	}
}