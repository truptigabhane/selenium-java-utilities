package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//Smoke testing
@CucumberOptions(
		dryRun=false,
		features={"src\\test\\resources\\features"},
		glue={"gluecode"},
		tags="@smoketest",
		monochrome=true,
		plugin={"pretty","html:target/smoketestres",
				         "json:target/smoketestres.json",
				         "junit:target/smoketestres.xml",
				         "rerun:target/failedsmoketestscenarios.txt"}
		)
public class Runner1 extends AbstractTestNGCucumberTests
{
	// This class will be empty by default 
}











