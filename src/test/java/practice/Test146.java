package practice;

import java.io.File;
import java.io.FileWriter;
import java.util.Properties;

public class Test146
{
	public static void main(String[] args) throws Exception
	{
		//Create object to "Properties" class
		Properties p=new Properties();
		//define Key-value pairs
		p.setProperty("name","abdul kalam");  
		p.setProperty("email","apj@abdulkalam.com"); 
		//Save a new properties file with those pairs
		File f=new File("src\\test\\resources\\config.properties");
		FileWriter fw=new FileWriter(f); //WRITE mode
		p.store(fw,"My results Properties file"); 
		
	}
}
