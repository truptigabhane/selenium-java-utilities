package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test141
{
	public static void main(String[] args) throws Exception
	{
		//Open an existing file in read mode
		File f=new File("src\\test\\resources\\mydata.txt");
		FileReader fr=new FileReader(f);  
	    BufferedReader br=new BufferedReader(fr);
	    //Get matched date value
	    Pattern p=Pattern.compile("([0-9]{2}[/][A-Za-z]{3}[/][0-9]{4})");
	    String line=null;
	    while((line=br.readLine())!=null) //loop terminates after last line's reading
	    {
	    	Matcher m=p.matcher(line);
	    	while(m.find())
	    	{
	    		System.out.println(m.group());
	    	}
	    }
	    //close files
	    br.close();
	    fr.close();
	}
}
