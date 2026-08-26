package dummyglue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExampleStepDef2 
{
	String str, strrev;
	
	@Given("take {string}")
	public void method4(String x)
	{
		str=x;
	}
	
	@When("do reverse")
	public void method5()
	{
		strrev="";
		for(int i=str.length()-1; i>=0; i--) //last char to 1st char
		{
			char y=str.charAt(i);
			strrev=strrev+y;
		}
	}
	
	@Then("display reverse output")
	public void method6()
	{
		System.out.println(strrev);
	}
}
