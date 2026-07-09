package practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test50
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver(); 
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://www.flipkart.com");
		Thread.sleep(5000); 
		//collect all links in page source
		List<WebElement> links=driver.findElements(By.tagName("a"));
		int totallinks=links.size();
		int nohreflinks=0;
		int localpagelinks=0;
		int correctlinks=0;
		int brokenlinks=0;
		int linkswithexception=0;
		//Goto each link
		for(WebElement link:links)
		{
			//1. check link has "href" attribute or not
			String hrefpath;
			if((hrefpath=link.getAttribute("href"))!=null)
			{
				//2. Check that attribute value starts with "http" or "https"
				if(hrefpath.startsWith("https") || hrefpath.startsWith("http"))
				{
					try
					{
						//3. Check link href address is working or not
						URL u=new URL(hrefpath);
						HttpURLConnection con=(HttpURLConnection) u.openConnection();
						con.connect(); //send a dummy request and get response
						if(con.getResponseCode()==200)
						{
							correctlinks++;
						}
						else
						{
							brokenlinks++;
							System.out.println(hrefpath+" is broken link due to "+
						                   con.getResponseMessage());
						}
					}
					catch(Exception ex)
					{
						linkswithexception++;
						System.out.println(hrefpath+" is raised "+ex.getMessage());
					}
				}
				else
				{
					localpagelinks++;
				}
			}
			else
			{
				nohreflinks++;
			}
		}
		System.out.println("Total links are "+totallinks);
		System.out.println("Links without href are "+nohreflinks);
		System.out.println("Local page links are "+localpagelinks);
		System.out.println("Correctly working links are "+correctlinks);
		System.out.println("Broken links are "+brokenlinks);
		System.out.println("Links raised exception are "+linkswithexception);
		//close site
		driver.close();
	}
}