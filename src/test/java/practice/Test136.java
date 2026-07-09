package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test136
{
	public static void main(String[] args) throws Exception
	{
		//Open existing file in read mode
		File f=new File("src\\test\\resources\\mydata.txt");
		FileReader fr=new FileReader(f);  
		//Load file into RAM as text file  
	    BufferedReader br=new BufferedReader(fr);
	    //Get upper-case words in each line
	    Pattern p=Pattern.compile("[A-Z][A-Z]+"); 
	    String line=null;
	    while((line=br.readLine())!=null) //loop terminates after last line's reading
	    {
	    	Matcher m=p.matcher(line);
	    	while(m.find())
	    	{
	    		System.out.println(m.group());
	    	}
	    }
	    //close file
	    br.close();
	    fr.close();
	}
}
