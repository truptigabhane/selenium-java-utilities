package practice;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class Test147
{
	public static void main(String[] args) throws Exception
	{
		//Open existing file in read mode
		File f=new File("src\\test\\resources\\config.properties");
		FileReader fr=new FileReader(f);  
		//Load file into RAM as a properties file  
	    Properties p=new Properties();  
	    p.load(fr); 
	    System.out.println("Count of properties in file is "+p.keySet().size());
	    //Get properties values from that file
	    System.out.println(p.getProperty("name"));  
	    System.out.println(p.getProperty("testleademailid")); 
	}
}
