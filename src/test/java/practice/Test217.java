package practice;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test217
{
	public static void main(String[] args)
	{
		//Range slider with min is fixed and max will be changed
		//Take value from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a value to set");
		int x=sc.nextInt();
		sc.close();
		//Open browser and launch site
		WebDriverManager.chromedriver().setup();         
        RemoteWebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withTimeout(Duration.ofSeconds(20));
		driver.get("http://rangeslider.js.org/");
		//set max value in range slider bar
	    WebElement slider=wait.until(ExpectedConditions.presenceOfElementLocated(
	    		                                 By.xpath("//input[@type='range']")));
	    driver.executeScript("$(arguments[0]).val("+x+").change();",slider);
	    //get output value
	    WebElement slideroutput=wait.until(
	    		ExpectedConditions.visibilityOfElementLocated(By.id("js-output")));
	    int y=Integer.parseInt(slideroutput.getText());
		//round the input value because output is rounded value in range sliders
		x=(int)(Math.round(x/10.0)*10); 
		if(x==y)
		{
			System.out.println("Test passed");
        }
        else
        {
        	System.out.println("Test failed");
        }
        //close site
        //driver.close();
	}
}
