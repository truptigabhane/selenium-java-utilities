package practice;

import java.util.Properties;
import java.util.Set;

public class Test149
{
	public static void main(String[] args) throws Exception
	{
		//Get in-built properties related to our OS
		Properties p=System.getProperties(); //key and value pairs
		Set<Object> keys=p.keySet(); //get all keys
		for(Object key:keys) //get values using keys
		{
			System.out.println(key.toString()+"="+p.getProperty(key.toString()));
		}
	}
}
