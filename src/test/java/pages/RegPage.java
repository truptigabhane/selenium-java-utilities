package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class RegPage
{
	//Properties for locating elements
	private RemoteWebDriver driver;
	private FluentWait<RemoteWebDriver> wait;
	@FindBy(name="nickname") @CacheLookup 
	private WebElement uname;
	@FindBy(name="email") @CacheLookup 
	private WebElement emailid;
	@FindBy(name="password") @CacheLookup 
	private WebElement pwd;
	@FindBy(name="confirm") @CacheLookup 
	private WebElement confirmpwd;
	@FindBy(xpath="(//*[name()='svg'])[4]") @CacheLookup 
	private WebElement terms;
	@FindBy(xpath="//button[text()='Create My Free Account']") @CacheLookup 
	private WebElement create;
	@FindBy(xpath="//div[text()='Please enter a username']") 
	private WebElement uname_blank_err;
	@FindBy(xpath="//div[text()='Please enter your email address']") 
	private WebElement email_blank_err;
	@FindBy(xpath="//div[text()='Please enter a password']") 
	private WebElement pwd_blank_err;
	@FindBy(xpath="//div[text()='Enter a password longer than 6 characters']") 
	private WebElement pwd_size_err;
	@FindBy(xpath="//div[text()='Please confirm your password']") 
	private WebElement confirm_pwd_blank_err;
	@FindBy(xpath="//div[text()=\"Passwords don't match\"]") 
	private WebElement confirm_pwd_mismatch_err;
	@FindBy(xpath="//div[contains(text(),'agree to the Terms')]") 
	private WebElement terms_err;
	@FindBy(xpath="//div[contains(text(),'This email is already used')]") 
	private WebElement duplicate_email_err;
	
	//Constructor method for connecting to step definition classes and runner classes
	public RegPage(RemoteWebDriver driver, FluentWait<RemoteWebDriver> wait)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
		this.wait=wait;
	}
	
	//Operational methods to operate and observe elements
	public boolean areAllElementsDisplayed()
	{
		if(uname.isDisplayed() && emailid.isDisplayed() && pwd.isDisplayed() && 
				confirmpwd.isDisplayed() && terms.isDisplayed() && create.isDisplayed())
		{
			return(true);
		}
		else
		{
			return(false);
		}
	}
	public void fillUserName(String word)
	{
		wait.until(ExpectedConditions.visibilityOf(uname)).sendKeys(word);
	}
	public void fillEmailID(String word)
	{
		wait.until(ExpectedConditions.visibilityOf(emailid)).sendKeys(word);
	}
	public void fillPassword(String word)
	{
		wait.until(ExpectedConditions.visibilityOf(pwd)).sendKeys(word);
	}
	public void fillConfirmPassword(String word)
	{
		wait.until(ExpectedConditions.visibilityOf(confirmpwd)).sendKeys(word);
	}
	public void clickOnTerms()
	{
		wait.until(ExpectedConditions.visibilityOf(terms)).click();
	}
	public void clickOnCreate() throws Exception
	{
		wait.until(ExpectedConditions.visibilityOf(create)).submit();
		//fixed waiting time for outcome
		Thread.sleep(5000);
	}
	public boolean isUserNameBlankErrorDisplayed()
	{
		if(uname_blank_err.isDisplayed())
		{
			return(true);
		}
		else
		{
			return(false);
		}
	}
	public boolean isEmailBlankErrorDisplayed()
	{
		if(email_blank_err.isDisplayed())
		{
			return(true);
		}
		else
		{
			return(false);
		}
	}
	public boolean isPwdBlankErrorDisplayed()
	{
		if(pwd_blank_err.isDisplayed())
		{
			return(true);
		}
		else
		{
			return(false);
		}
	}
	public boolean isPwdSizeErrorDisplayed()
	{
		if(pwd_size_err.isDisplayed())
		{
			return(true);
		}
		else
		{
			return(false);
		}
	}
	public boolean isConfirmPwdBlankErrorDisplayed()
	{
		if(confirm_pwd_blank_err.isDisplayed())
		{
			return(true);
		}
		else
		{
			return(false);
		}
	}
	public boolean isConfirmPwdMismatchErrorDisplayed()
	{
		if(confirm_pwd_mismatch_err.isDisplayed())
		{
			return(true);
		}
		else
		{
			return(false);
		}
	}
	public boolean isTermsErrorDisplayed()
	{
		if(terms_err.isDisplayed())
		{
			return(true);
		}
		else
		{
			return(false);
		}
	}
	public boolean isDuplicateEmailIDErrorDisplayed()
	{
		if(duplicate_email_err.isDisplayed())
		{
			return(true);
		}
		else
		{
			return(false);
		}
	}
}



