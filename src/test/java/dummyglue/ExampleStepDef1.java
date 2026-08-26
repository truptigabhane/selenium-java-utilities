package dummyglue;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExampleStepDef1 
{
	int input1, input2, input3;
	
	@Given("take {int} and {int}")
	public void method1(int x, int y)
	{
		input1=x;
		input2=y;
	}
	
	@When("do addition")
	public void method2()
	{
		input3=input1+input2;
	}
	
	@Then("display addition output")
	public void nethod3()
	{
		System.out.println(input3);
	}
	
	@Given("subtract numbers")
	public void method4(DataTable dt)
	{
		 List<List<Integer>> l=dt.asLists(Integer.class);
		 for(int i=0;i<l.size();i++) //Data table without column names
		 {
			 int x=l.get(i).get(0);
			 int y=l.get(i).get(1);
			 int z=x-y;
			 System.out.println(z);
		 }
	}
	
	@Given("multiply numbers")
	public void method5(DataTable dt)
	{
		 List<Map<String,String>> l=dt.asMaps();
		 for(int i=0;i<l.size();i++) //Data table with column names
		 {
			 int x=Integer.parseInt(l.get(i).get("i1"));
			 int y=Integer.parseInt(l.get(i).get("i2"));
			 int z=x*y;
			 System.out.println(z);
		 }
	}
}
