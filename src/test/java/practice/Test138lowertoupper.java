package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test138lowertoupper
{
	public static void main(String[] args) throws Exception
	{
		//Open existing file in read mode
		File f=new File("src\\test\\resources\\mydata.txt");
		FileReader fr=new FileReader(f);  
		//Load file into RAM as text file  
	    BufferedReader br=new BufferedReader(fr);
	    //Get words starts with any case in each line
	    Pattern p=Pattern.compile("[A-Za-z][a-z]+"); 
	    List<String> ls=new ArrayList<String>();
	    String line=null;
	    while((line=br.readLine())!=null) //loop terminates after last line's reading
	    {
	    	Matcher m=p.matcher(line);
	    	while(m.find())
	    	{
	    		System.out.println(m.group());
	    		ls.add(m.group());
	    	}
	    }
	    //convert init lower to init upper
	    for(String l:ls)
	    {
	    	char fl=l.charAt(0); //get first letter
	    	l=l.substring(1); //Take from 2nd to remove first letter
	    	if(fl>=97) //if lower
	    	{
	    		fl=(char) (fl-32); //change first letter to upper case
	    	}
	    	l=fl+l; //add converted first letter to remaining word
	    	System.out.println(l);	
	    }
	    //close file
	    br.close();
	    fr.close();
	}
}
