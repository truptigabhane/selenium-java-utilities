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

public class StepDef3
{
	WebSiteUtility su;
	RemoteWebDriver driver;
	FluentWait<RemoteWebDriver> wait;
	Scenario se;
	RegPage rp;
	ConfirmPage cp;
	public StepDef3(Shared sh)
	{
		this.driver=sh.driver;
		this.se=sh.se;
		this.wait=new FluentWait<RemoteWebDriver>(this.driver);
		this.rp=new RegPage(this.driver,wait);
		this.cp=new ConfirmPage(this.driver,wait);	
	}
	//From feature5
	@When("fill username with {string} data")
	public void fill_username_with_data(String x) 
	{
		rp.fillUserName(x);
	}
	@When("fill email with {string} data")
	public void fill_email_with_data(String x)
	{
		if(x.equals("random-email"))
		{
			rp.fillEmailID(RandomUtility.generateRandomEmail());
		}
		else
		{
			rp.fillEmailID(x);
		}
	}
	@When("fill password with {string} data")
	public void fill_password_with_data(String x)
	{
		rp.fillPassword(x);
	}
	@When("fill confirm password with {string} data")
	public void fill_confirm_password_with_data(String x)
	{
		rp.fillConfirmPassword(x);
	}
	@Then("related msg should be displayed as per {string}")
	public void related_msg_should_be_displayed_as_per(String criteria) throws Exception
	{
		if(criteria.equals("all_valid") && cp.isConfirmationMsgDisplayed() && 
				cp.isEmailMsgDisplayed() && cp.isEmailAgainDisplayed())
		{
			se.log("Test passed when all fields are valid");
		}
		else if(criteria.equals("un_blank") && rp.isUserNameBlankErrorDisplayed())
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
		else if(criteria.equals("em_alreadyused") && rp.isDuplicateEmailIDErrorDisplayed())
		{
			se.log("Duplicate email error msg is displayed");
		}
		else if(criteria.equals("em_wrongformat") && rp.isEmailBlankErrorDisplayed())
		{
			se.log("Invalid email error msg is displayed");
		}
		else if(criteria.equals("pwd_wrongsize") && rp.isPwdSizeErrorDisplayed())
		{
			se.log("Password size error msg is displayed");
		}
		else if(criteria.equals("cpwd_wrong") && rp.isConfirmPwdMismatchErrorDisplayed())
		{
			se.log("Password and confirm password does not match error msg is displayed");
		}
		else
		{
			se.log("Test failed");
			byte[] b=driver.getScreenshotAs(OutputType.BYTES);
			se.attach(b, "image/png", criteria);
			Assert.fail();
		}
	}
	@When("clear data in DB")
	public void clear_data_in_DB()
	{
		//connect to DB
		//clear register data by running delete query on corresponding table in DB
		//disconnect from DB
	}
}








