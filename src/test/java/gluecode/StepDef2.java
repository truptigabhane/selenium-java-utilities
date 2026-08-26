package gluecode;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ConfirmPage;
import pages.RegPage;
import utilities.RandomUtility;
import utilities.WebSiteUtility;

public class StepDef2
{
	WebSiteUtility su;
	RemoteWebDriver driver;
	FluentWait<RemoteWebDriver> wait;
	Scenario se;
	RegPage rp;
	ConfirmPage cp;
	Shared sh;
	public StepDef2(Shared sh)
	{
		this.sh=sh;
		this.driver=sh.driver;
		this.se=sh.se;
		this.wait=new FluentWait<RemoteWebDriver>(this.driver);
		this.rp=new RegPage(driver,wait);
		this.cp=new ConfirmPage(driver,wait);	
	}
	
	@When("do successful registartion by using")
	public void method1(String data) throws Exception
	{
		//split data into pieces based on comma
		String[] arr=data.split(",");
		rp.fillUserName(arr[0]);
		if(arr[1].equals("random-email"))
		{
			rp.fillEmailID(RandomUtility.generateRandomEmail()); 
		}
		rp.fillPassword(arr[2]);
		rp.fillConfirmPassword(arr[2]); //password and confirm password should be same
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
	
	@When("fill fields with {string} data")
	public void method2(String data)
	{
		//split data into pieces based on comma
		String[] arr=data.split(",");
		rp.fillUserName(arr[0]);
		if(arr[1].equals("random-email"))
		{
			rp.fillEmailID(RandomUtility.generateRandomEmail()); 
		}
		rp.fillPassword(arr[2]);
		rp.fillConfirmPassword(arr[2]); //password and confirm password should be same
	}
	
	@When("select terms checkbox")
	public void method3()
	{
		rp.clickOnTerms();
	}
	
	@When("click on button")
	public void method4() throws Exception
	{
		rp.clickOnCreate();
	}
	
    @Then("{string} msg should be displayed")
	public void method5(String msg)
	{
		if(cp.isConfirmationMsgDisplayed() 
				&& cp.isEmailMsgDisplayed() 
				&& cp.isEmailAgainDisplayed())
		{
			se.log(msg+" is displayed");
		}
		else
		{
			se.log(msg+" is not displayed");
			byte[] s=driver.getScreenshotAs(OutputType.BYTES);
			se.attach(s,"image/png","wrong page screen shot");
			Assert.fail();
		}
	}
    
    @When("fill fields with {string} ,{string} ,{string} and {string} data")
	public void method6(String x,String y,String z,String p) throws Exception
	{
    	rp.fillUserName(x);
    	if(y.equals("random-email"))
		{
    		rp.fillEmailID(RandomUtility.generateRandomEmail()); 
		}
    	else
		{
    		rp.fillEmailID(y);
		}
		rp.fillPassword(z);
		rp.fillConfirmPassword(p);
		rp.clickOnTerms();
		rp.clickOnCreate();
	}
    
    @Then("related error msg should be displayed as per {string}")
	public void method7(String criteria)
	{
		if(criteria.equals("un_blank") && rp.isUserNameBlankErrorDisplayed())
		{
			se.log("Blank User name error msg is displayed");
		}
		else if(criteria.equals("em_blank") && rp.isEmailBlankErrorDisplayed())
		{
			se.log("Blank email error msg is displayed");
		}
		else if(criteria.equals("pwd_blank") && rp.isPwdBlankErrorDisplayed())
		{
			se.log("Blank password error msg is displayed");
		}
		else if(criteria.equals("cpwd_blank") && rp.isConfirmPwdBlankErrorDisplayed())
		{
			se.log("Blank confirm password error msg is displayed");
		}
		else if(criteria.equals("em_duplicate") && rp.isDuplicateEmailIDErrorDisplayed())
		{
			se.log("Duplicate email error msg is displayed");
		}
		else if(criteria.equals("em_wrongemailformat") && rp.isEmailBlankErrorDisplayed())
		{
			se.log("Wrong email format error msg is displayed");
		}
		else if(criteria.equals("pwd_wrongpwdsize") && rp.isPwdSizeErrorDisplayed())
		{
			se.log("Wrong password size error msg is displayed");
		}
		else if(criteria.equals("cpwd_wrong") && rp.isConfirmPwdMismatchErrorDisplayed())
		{
			se.log("Confirm password mismatch error msg is displayed");
		}
		else
		{
			se.log("No error msg is displayed as per "+criteria);
			byte[] s=driver.getScreenshotAs(OutputType.BYTES);
			se.attach(s,"image/png","wrong page screen shot");
			Assert.fail();
		}
	}
}
