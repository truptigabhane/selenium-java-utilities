package gluecode;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.When;
import pages.ConfirmPage;
import pages.RegPage;
import utilities.RandomUtility;
import utilities.WebSiteUtility;

public class StepDef4
{
	WebSiteUtility su;
	RemoteWebDriver driver;
	FluentWait<RemoteWebDriver> wait;
	Scenario se;
	RegPage rp;
	ConfirmPage cp;
	public StepDef4(Shared sh)
	{
		this.driver=sh.driver;
		this.se=sh.se;
		this.wait=new FluentWait<RemoteWebDriver>(this.driver);
		this.rp=new RegPage(this.driver,wait);
		this.cp=new ConfirmPage(this.driver,wait);	
	}
	//From feature6
	@When("do successful registartion for given valid data")
	public void method1(DataTable data) throws Exception
	{
		//data is passed as a list
		List<String> arr=data.asList();
		for(int i=0;i<arr.size();i++)
		{
			String pieces[]=arr.get(i).split(",");
			rp.fillUserName(pieces[0]);
			if(pieces[1].equals("random-email"))
			{
				rp.fillEmailID(RandomUtility.generateRandomEmail()); 
			}
			rp.fillPassword(pieces[2]);
			rp.fillConfirmPassword(pieces[2]); //password and confirm password should be same
			rp.clickOnTerms();
			rp.clickOnCreate();
			if(cp.isConfirmationMsgDisplayed())
			{
				se.log("Registration is successful");
			}
			else
			{
				se.log("Registration is not successful");
				byte[] s=driver.getScreenshotAs(OutputType.BYTES);
				se.attach(s,"image/png","wrong page screen shot");
				Assert.fail();
			}
		}
	}
	
	@When("do successful registartion by giving valid data")
	public void method2(DataTable data) throws Exception
	{
		//data is passed as a list
		List<Map<String,String>> arr=data.asMaps();
		for(int i=0;i<arr.size();i++)
		{
			rp.fillUserName(arr.get(i).get("un"));
			if(arr.get(i).get("email").equals("random-email"))
			{
				rp.fillEmailID(RandomUtility.generateRandomEmail()); 
			}
			rp.fillPassword(arr.get(i).get("pwd"));
			rp.fillConfirmPassword(arr.get(i).get("pwd")); //password and confirm password should be same
			rp.clickOnTerms();
			rp.clickOnCreate();
			if(cp.isConfirmationMsgDisplayed())
			{
				se.log("Registration is successful");
			}
			else
			{
				se.log("Registration is not successful");
				byte[] s=driver.getScreenshotAs(OutputType.BYTES);
				se.attach(s,"image/png","wrong page screen shot");
				Assert.fail();
			}
		}
	}
	
	@When("do successful registartion by giving valid data in {string}")
	public void method3(String bn,DataTable dt) throws Exception
	{
		//data is passed as a list
		List<Map<String,String>> arr=dt.asMaps();
		for(int i=0;i<arr.size();i++)
		{
			rp.fillUserName(arr.get(i).get("un"));
			if(arr.get(i).get("email").equals("random-email"))
			{
				rp.fillEmailID(RandomUtility.generateRandomEmail()); 
			}
			rp.fillPassword(arr.get(i).get("pwd"));
			rp.fillConfirmPassword(arr.get(i).get("pwd")); //password and confirm password should be same
			rp.clickOnTerms();
			rp.clickOnCreate();
			if(cp.isConfirmationMsgDisplayed())
			{
				se.log("Registration is successful in "+bn);
			}
			else
			{
				se.log("Registration is not successful in "+bn);
				byte[] s=driver.getScreenshotAs(OutputType.BYTES);
				se.attach(s,"image/png","wrong page screen shot");
				Assert.fail();
			}
		}
	}
}








