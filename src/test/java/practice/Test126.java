package practice;

import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;


public class Test126
{
	public static void main(String[] args) throws Exception
	{
		//Open browser 
		WebDriverManager.chromedriver().setup();       
        RemoteWebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        //launch site
        driver.get("https://semantic-ui.com/modules/dropdown.html");
        Thread.sleep(5000);
        //Get screenshot of an element
        WebElement e=driver.findElement(By.xpath(
        		               "//h4[text()='Inline']/following-sibling::span/div"));
        File f1=e.getScreenshotAs(OutputType.FILE);
        File dest1=new File("target/elescreenshot.png");
        FileHandler.copy(f1,dest1);
        //Get screenshot of visible area of page on desktop
        File f2=driver.getScreenshotAs(OutputType.FILE);
        File dest2=new File("target\\pagescreenshot.png");
        FileHandler.copy(f2,dest2);
        //Get screenshot of complete page using Ashot
        AShot as=new AShot();
        ShootingStrategy shs=ShootingStrategies.viewportPasting(1000); //1 second delay
        Screenshot ss=as.shootingStrategy(shs).takeScreenshot(driver);
        File dest=new File("target\\fullpagescreenshot.png");
        ImageIO.write(ss.getImage(),"PNG",dest); 
        //close site
        driver.close();
	}
}
