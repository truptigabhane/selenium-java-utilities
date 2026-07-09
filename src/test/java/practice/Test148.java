package practice;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.configuration.PropertiesConfiguration;

public class Test148
{
	public static void main(String[] args) throws Exception
	{
		//Open an existing file, read values, edit values and save that file
		File f=new File("src\\test\\resources\\config.properties");
	    //Edit values("commons-configuration" jar file is required)
		PropertiesConfiguration pc=new PropertiesConfiguration(f);
        pc.setProperty("name","Mr. abdul kalam sir"); //new value for existing property
        pc.save();
        //Read all properties values
      	FileReader fr=new FileReader(f);  
      	Properties p=new Properties();  
      	p.load(fr); 
      	Set<Object> keys=p.keySet(); //get all keys
      	for(Object key:keys) //get values using keys
      	{
      		System.out.println(key.toString()+"="+p.getProperty(key.toString()));
      	}
	}
}
