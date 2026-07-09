package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.CarouselSliderUtility;

public class Test62
{
	public static void main(String[] asdf) throws Exception
	{
		//carousel-3d
		//Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://mdbootstrap.com/docs/b4/jquery/plugins/carousel-3d/");
		Thread.sleep(5000); //fixed wait
		CarouselSliderUtility obj=new CarouselSliderUtility();
		for(int i=1;i<=4;i++)
		{
			//Locate carousel slider element
			WebElement slider=driver.findElement(By.xpath(
											"(//div[@class='carousel-3d-inner'])["+i+"]"));
			//apply test cases
			System.out.println(obj.getCountOfSlides(slider));
			System.out.println(obj.getTypeOfSlider(slider));
			if(obj.areSlidesMovingAutomaticallyInSlider(slider))
			{
				System.out.println(obj.getMovingDirectionOfSlidesInSlider(slider));
			}
			else
			{
				System.out.println("Slides are not moving");
			}
			System.out.println("Each slide moving duration is "+obj.getSlideMoveDuration(slider));
			System.out.println(obj.getslideMovingStyle(slider));
			System.out.println("Delay between slides is "+obj.getDelayBetweenSlidesMove(slider));
		}
		//close site
		driver.close();
	}
}
