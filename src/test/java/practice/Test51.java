package practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test51
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
		//collect all elements in page source
		List<WebElement> elements=driver.findElements(By.xpath("//*"));
		int totalelements=elements.size();
		int nohrefelements=0;
		int localpagelinks=0;
		int correctlinks=0;
		int brokenlinks=0;
		int linkswithexception=0;
		//Take each element
		for(WebElement element:elements)
		{
			//1. check "href" attribute available or not
			String hrefpath;
			if((hrefpath=element.getAttribute("href"))!=null)
			{
				//2. Check that attribute value starts with "http" or "https"
				if(hrefpath.startsWith("https") || hrefpath.startsWith("http"))
				{
					try
					{
						//3. Check link href address is working or not
						URL u=new URL(hrefpath);
						HttpURLConnection con=(HttpURLConnection) u.openConnection();
						con.connect();
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
				nohrefelements++;
			}
		}
		System.out.println("Total elements are "+totalelements);
		System.out.println("Elements without href are "+nohrefelements);
		System.out.println("Total links are "+(totalelements-nohrefelements));
		System.out.println("Local page links are "+localpagelinks);
		System.out.println("Correctly working links are "+correctlinks);
		System.out.println("Broken links are "+brokenlinks);
		System.out.println("Links raised exception are "+linkswithexception);
		//close site
		driver.close();
	}
}