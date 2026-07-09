package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ChatBotUtility;

public class Test63
{	
	public static void main(String[] args) throws Exception
	{
		String q="how are you?";
		//open browser and Launch site
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.chatbot.com/");
		Thread.sleep(5000);
		//Activate chat-bot dialog
		driver.switchTo().frame("chat-widget");
		driver.findElement(By.className("lazy-img-loaded")).click();
		Thread.sleep(5000);
		//send question to server
		driver.findElement(By.xpath("//*[@placeholder='Type your message here']"))
		                                                   .sendKeys(q,Keys.ENTER);
		Thread.sleep(5000);
		//Get actual answer given by server
		String actualres=driver.findElement(By.xpath(
				"(//div[@data-Type='BOT_RESPONSE_text'])[2]")).getText();
		System.out.println(actualres); //answer came from server for given question
		//Compare with expected answer paired for given question in "static" block
		String mappedres=ChatBotUtility.getResponse(q);
		System.out.println(mappedres); 
		if(actualres.contains(mappedres))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test failed");
		}
		//close site
		driver.switchTo().defaultContent();
		driver.close();
	}
}
