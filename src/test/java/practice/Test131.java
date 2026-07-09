package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test131
{
	RemoteWebDriver driver;
	ATUTestRecorder recorder;
	List<String> names;
	List<Integer> prices;
	File zipfile;
	String vp;
	
	@Test(priority=1)
	public void method1() throws Exception
	{
		//Start recording
		SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
        Date dt=new Date();
        vp="target\\"+sf.format(dt); //".mov" is default extension
        recorder=new ATUTestRecorder(vp,false); //false means no audio
        recorder.start();
	}
	@Test(priority=2)
	public void method2() throws Exception
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
		catch(Exception ex1)
		{
			try
			{
				driver.findElement(By.xpath("//span[@role='button']")).click();
				Thread.sleep(5000);
			}
			catch(Exception ex2)
			{
				System.out.println("No banner for this time");
			}
		}
	}
	@Test(priority=3)
	public void method3() throws Exception
	{
		//click on "mobiles" link
		driver.findElement(By.xpath("(//div[text()='Mobiles'])|(//span[text()='Mobiles'])"))
																				.click();
		Thread.sleep(5000);
		//click on "Realme" 
		driver.findElement(By.xpath("//p[text()='Realme']")).click();
		Thread.sleep(5000);
		//collect and display name and price of each model via pagination
		int total=0;
		names=new ArrayList<String>();
		prices=new ArrayList<Integer>();
		while(true) //pagination
		{
			//Step-1:collect all models in current page
			List<WebElement> models=driver.findElements(By.xpath(
					                   "//div[starts-with(@data-id,'MOB')]"));
			total=total+models.size();
			//Step-2:goto each model to get name and price
			for(WebElement model:models)
			{
				String price=model.findElement(By.xpath(
						"descendant::div[contains(@class,'col-5-12')]/div[1]/div[1]/div[1]"))
						.getText();
				if(!price.contains("Not Available"))
				{
					//get name and add to names list
					String name=model.findElement(By.xpath(
						"descendant::div[contains(@class,'col-7-12')]/div[1]")).getText();
					names.add(name);
					//alter price and add to prices list
					price=price.substring(1); //remove currency symbol at index=0
					price=price.replace(",",""); //remove ","
					int p=Integer.parseInt(price);
					prices.add(p);
				}
			}
			//Step-3:goto next page if exists
			try
			{
				driver.findElement(By.xpath("//span[text()='Next']")).click();
				Thread.sleep(3000);
			}
			catch(Exception e)
			{
				break; //terminate from loop
			}
		}
		Reporter.log("Total models are "+total);
	}
	@Test(priority=4)
	public void method4() throws Exception
	{
		//Find highest price and corresponding model name
		String maxmodel=names.get(0);
		int maxprice=prices.get(0);
		for(int i=1;i<prices.size();i++) //compare from 2nd item to last item
		{
			if(prices.get(i)>maxprice)
			{
				maxprice=prices.get(i);
				maxmodel=names.get(i);
			}
		}
		Reporter.log("Maximum price "+maxprice+" model is "+maxmodel);
		//Find lowest price and corresponding model name
		String minmodel=names.get(0);
		int minprice=prices.get(0);
		for(int i=1;i<prices.size();i++) //compare from 2nd item to last item
		{
			if(prices.get(i)<minprice)
			{
				minprice=prices.get(i);
				minmodel=names.get(i);
			}
		}
		Reporter.log("Minimum price "+minprice+" model is "+minmodel);
	}
	
	@Test(priority=5, enabled=false)
	public void method5() throws Exception
	{
		//close browser
		driver.quit();
	}
	
	@Test(priority=6)
	public void method6() throws Exception
	{
		//stop recording
		recorder.stop();
	}
	@Test(priority=7)
	public void method7() throws Exception
	{
		//convert video file into zip file(time taking)
		File fileToZip=new File(vp+".mov");
        FileInputStream fis=new FileInputStream(fileToZip);
		zipfile=new File(vp+".zip");
		FileOutputStream fos=new FileOutputStream(zipfile);
        ZipOutputStream zipOut=new ZipOutputStream(fos);
        ZipEntry zipEntry=new ZipEntry(fileToZip.getName());
        zipOut.putNextEntry(zipEntry);
        byte[] bytes=new byte[1024];
        int length;
        while((length=fis.read(bytes))>=0) 
        {
            zipOut.write(bytes, 0, length);
        }
        zipOut.close();
        fis.close();
        fos.close();
        Reporter.log("Zip completed.");
	}
	@Test(priority=8)
	public void method8() throws Exception
	{
		//forward that zip file to management via email
		//Create object to Properties class and set "host" values
		Properties props=new Properties();
		props.put("mail.smtp.host","smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port","465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.port","465");
		// This will handle the complete authentication
		Authenticator auth=new Authenticator()
		{
			protected PasswordAuthentication getPasswordAuthentication() 
			{
				return new PasswordAuthentication("magnitiait","iufdfrvdfeehpepw");
			}
		};
		//Create object of Session class by using properties and authentication info
		Session session=Session.getDefaultInstance(props,auth);
		//Create object of Message class and set details
		Message msg=new MimeMessage(session);
		msg.setFrom(new InternetAddress("magnitiait@gmail.com"));
		msg.setRecipients(Message.RecipientType.TO,
				          InternetAddress.parse("magnitiait@gmail.com"));
		msg.setSubject("Testing Subject");
		// Create object to add multimedia type content
		BodyPart bodymsg1=new MimeBodyPart();
		bodymsg1.setText("This is message body");
		BodyPart bodymsg2=new MimeBodyPart();
		String filename=zipfile.getAbsolutePath();
		DataSource source=new FileDataSource(filename);
		bodymsg2.setDataHandler(new DataHandler(source));
		bodymsg2.setFileName(filename);
		// Create object of MimeMultipart class
		Multipart mpart=new MimeMultipart();
		mpart.addBodyPart(bodymsg1);
		mpart.addBodyPart(bodymsg2);
		msg.setContent(mpart);
		// Finally send the email
		Transport.send(msg);
		Reporter.log("=====Email Sent=====");
	}
}
