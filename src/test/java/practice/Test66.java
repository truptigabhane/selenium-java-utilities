package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.CarouselSliderUtility;

public class Test66
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver(); 
		driver.manage().window().maximize();
		//Launch site(amazon.in)
		driver.get("https://www.toyota.com.br");
		Thread.sleep(5000); 
		//Locate carousel slider(Slick Carousel is a popular and widely used JavaScript library
		//for creating responsive and customizable carousel sliders on web pages.)
		WebElement slider=driver.findElement(By.xpath("(//div[@class='slick-track'])[1]"));
		//apply test cases
		CarouselSliderUtility obj=new CarouselSliderUtility();
		System.out.println(obj.getCountOfSlides(slider));
		System.out.println(obj.getTypeOfSlider(slider));
		//are they moving?
		WebElement currentSlideElement=slider.findElement(By.xpath(
				                                    "//*[contains(@class,'slick-current')]"));
		String currentSlideIndexAttribute1= 
				currentSlideElement.findElement(By.xpath("descendant::img")).getAttribute("src");
		Thread.sleep(3000); //wait some time
		currentSlideElement = slider.findElement(By.xpath(
                                                      "//*[contains(@class,'slick-current')]"));
		String currentSlideIndexAttribute2 = 
				currentSlideElement.findElement(By.xpath("descendant::img")).getAttribute("src");
		if(!currentSlideIndexAttribute1.equals(currentSlideIndexAttribute2))
		{
			System.out.println("Slides are moving");
			// Get the CSS properties of the current slide
	        String parentLeftValue=(String)driver.executeScript(
	         "return(window.getComputedStyle(arguments[0].parentNode).getPropertyValue('left'));", 
	         currentSlideElement);
	        // Print the value
	        System.out.println("Parent Left value: "+parentLeftValue);
			String direction;
			if(parentLeftValue.contains("-")) 
			{
			    direction="Right to Left";
			} 
			else 
			{
			    direction="Left to Right";
			} 
			System.out.println("Slide direction: "+direction);
		}
		else
		{
			System.out.println("Slides are not moving");
		}
		System.out.println("Each slide moving duration is "+obj.getSlideMoveDuration(slider));
		System.out.println(obj.getslideMovingStyle(slider));
		System.out.println("Delay between slides is "+obj.getDelayBetweenSlidesMove(slider));
		//close site
		driver.close();
	}
}
