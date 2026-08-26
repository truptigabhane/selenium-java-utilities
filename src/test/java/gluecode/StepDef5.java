package gluecode;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.When;
import pages.ConfirmPage;
import pages.RegPage;
import utilities.ExcelFileUtility;
import utilities.RandomUtility;
import utilities.TextFileUtility;
import utilities.WebSiteUtility;

public class StepDef5
{
	WebSiteUtility su;
	RemoteWebDriver driver;
	FluentWait<RemoteWebDriver> wait;
	Scenario se;
	RegPage rp;
	ConfirmPage cp;
	public StepDef5(Shared sh)
	{
		this.driver=sh.driver;
		this.se=sh.se;
		this.wait=new FluentWait<RemoteWebDriver>(this.driver);
		this.rp=new RegPage(this.driver,wait);
		this.cp=new ConfirmPage(this.driver,wait);	
	}
	//From feature9
	@When("do registartion by taking test data from text file")
	public void method1() throws Exception
	{
		int n=TextFileUtility.getCountOfLinesInTextFile(
				       "src\\test\\resources\\testdatafiles\\testdata.txt");
		for(int i=1;i<=n;i++)
		{
			String pieces[]=TextFileUtility.getValueInTextFile(
					"src\\test\\resources\\testdatafiles\\testdata.txt", i);
			rp.fillUserName(pieces[0]);
			if(pieces[1].equals("random-email"))
			{
				rp.fillEmailID(RandomUtility.generateRandomEmail()); 
			}
			else
			{
				rp.fillEmailID(pieces[1]);
			}
			rp.fillPassword(pieces[2]);
			rp.fillConfirmPassword(pieces[2]); //password and confirm password should be same
			rp.clickOnTerms();
			rp.clickOnCreate();
			if(pieces[3].equals("all_valid") && cp.isConfirmationMsgDisplayed())
			{
				se.log("Registration test case is passed for "+pieces[3]);
			}
			else if(pieces[3].equals("duplicate_email") && rp.isDuplicateEmailIDErrorDisplayed())
			{
				se.log("Registration test case is passed for "+pieces[3]);
			}
			else if(pieces[3].equals("uname_blank") && rp.isUserNameBlankErrorDisplayed())
			{
				se.log("Registration test case is passed for "+pieces[3]);
			}
			else if(pieces[3].equals("pwd_blank") && rp.isPwdBlankErrorDisplayed())
			{
				se.log("Registration test case is passed for "+pieces[3]);
			}
			else if(pieces[3].equals("email_blank") && rp.isEmailBlankErrorDisplayed())
			{
				se.log("Registration test case is passed for "+pieces[3]);
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
	
	@When("do registartion by taking test data from excel file")
	public void method2() throws Exception
	{
		//open excel file, get rows count, and create result column
		ExcelFileUtility eu=new ExcelFileUtility(
				      "src\\test\\resources\\testdatafiles\\testdata.xlsx");
		eu.openSheet("Sheet1");
		int n=eu.getRowsCount();
		eu.createResultColumn(n);
		try 
		{
			//iterate through from 2nd row to last row for data driven
			for(int i=1;i<n;i++) //skip 1st row(index=0) due names of columns
			{
				rp.fillUserName(eu.getCellValue(i,0));
				if(eu.getCellValue(i,1).equals("yes"))
				{
					rp.fillEmailID(RandomUtility.generateRandomEmail()); 
				}
				else
				{
					rp.fillEmailID(""); //send blank email
				}
				rp.fillPassword(eu.getCellValue(i,2));
				rp.fillConfirmPassword(eu.getCellValue(i,2)); //password and confirm password should be same
				rp.clickOnTerms();
				rp.clickOnCreate();
				if(eu.getCellValue(i,3).equals("all_valid") && cp.isConfirmationMsgDisplayed())
				{
					eu.setCellValue(i,n,"Registration test case is passed for "+eu.getCellValue(i,3));
					se.log("Registration test case is passed for "+eu.getCellValue(i,3));
				}
				else if(eu.getCellValue(i,3).equals("uname_blank") && rp.isUserNameBlankErrorDisplayed())
				{
					eu.setCellValue(i,n,"Registration test case is passed for "+eu.getCellValue(i,3));
					se.log("Registration test case is passed for "+eu.getCellValue(i,3));
				}
				else if(eu.getCellValue(i,3).equals("pwd_blank") && rp.isPwdBlankErrorDisplayed())
				{
					eu.setCellValue(i,n,"Registration test case is passed for "+eu.getCellValue(i,3));
					se.log("Registration test case is passed for "+eu.getCellValue(i,3));
				}
				else if(eu.getCellValue(i,3).equals("email_blank") && rp.isEmailBlankErrorDisplayed())
				{
					eu.setCellValue(i,n,"Registration test case is passed for "+eu.getCellValue(i,3));
					se.log("Registration test case is passed for "+eu.getCellValue(i,3));
				}
				else
				{
					eu.setCellValue(i,n,"Registration test case is failed for "+eu.getCellValue(i,3));
					se.log("Registration test case is failed for "+eu.getCellValue(i,3));
					byte[] s=driver.getScreenshotAs(OutputType.BYTES);
					se.attach(s,"image/png","wrong page screen shot");
					Assert.fail();
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//save and close excel file
		eu.saveAndCloseExcel();
	}
	
	@When("do registartion by taking test data from DB")
	public void method3()
	{
		//connect to DB
		//get data from DB
		//Use that data to do registration
		//validate if registration is successful
		//disconnect from DB
	}
}








