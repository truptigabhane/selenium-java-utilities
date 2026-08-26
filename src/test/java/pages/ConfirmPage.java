package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class ConfirmPage
{
	//Properties for locating elements
	private RemoteWebDriver driver;
	private FluentWait<RemoteWebDriver> wait;
	@FindBy(xpath="//h3[\"Let's Confirm Your Email!\"]") 
	private WebElement confirmmsg;
	@FindBy(xpath="//div[contains(text(),'We sent a confirmation email to')]") 
	private WebElement emailmsg;
	@FindBy(xpath="//button[text()='Not getting the email?']") 
	private WebElement emailagain;
	//Constructor method for connecting to step definition classes and runner classes
	public ConfirmPage(RemoteWebDriver driver, FluentWait<RemoteWebDriver> wait)
    {
		PageFactory.initElements(driver,this);
		this.driver=driver;
		this.wait=wait;
	}
	//Operational methods
	public boolean isConfirmationMsgDisplayed()
	{
		if(confirmmsg.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean isEmailMsgDisplayed()
	{
		if(emailmsg.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean isEmailAgainDisplayed()
	{
		if(emailagain.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
