package practice;

import java.io.File;
import java.io.FileWriter;
import java.util.Properties;

public class Test146append
{
	public static void main(String[] args) throws Exception
	{
		//Create object to "Properties" class
		Properties p=new Properties();
		//define Key-value pairs
		p.setProperty("testleadname","abdul kalam1234567");  
		p.setProperty("testleademail","apj1234567@abdulkalam.com"); 
		//Save a new properties file with those pairs
		File f=new File("src\\test\\resources\\config.properties");
		FileWriter fw=new FileWriter(f,true); //true indicates APPEND mode
		p.store(fw,"Data from Jessy");  
	}
}
