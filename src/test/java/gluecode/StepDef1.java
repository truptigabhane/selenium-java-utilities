package gluecode;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ConfirmPage;
import pages.RegPage;
import utilities.WebSiteUtility;

public class StepDef1
{
	WebSiteUtility su;
	RemoteWebDriver driver;
	FluentWait<RemoteWebDriver> wait;
	Scenario se;
	RegPage rp;
	ConfirmPage cp;
	Shared sh;
	public StepDef1(Shared sh)
	{
		this.sh=sh;
		this.se=sh.se;
	}
	
	@Given("open {string} browser")
	public void method1(String bn) throws Exception
	{
		su=new WebSiteUtility();
		sh.driver=su.openBrowser(bn); //important to create shared driver
		this.driver=sh.driver; //important to assign shared driver to local driver 
		wait=su.defineWait(driver);
		rp=new RegPage(driver,wait);
		cp=new ConfirmPage(driver,wait);
	}
	
	@When("launch site")
	public void method2() throws Exception
	{
		su.launchSite(sh.driver);
	}
	
	@Then("title should be contain {string}")
	public void method3(String title)
	{
		if (driver.getTitle().contains(title))
		{
			se.log("title is correct");
		}
		else
		{
			se.log("title is incorrect because it is "+driver.getTitle());
			Assert.fail();
		}
	}
	
	@Then("page should be contain required fileds")
	public void method4()
	{
		if (rp.areAllElementsDisplayed())
		{
			se.log("page is loaded with required fields");
		}
		else
		{
			se.log("page is not loaded with required fields");
			Assert.fail();
		}
	}
	
	@When("close site")
	public void method5()
	{
		driver.quit();
	}
}
