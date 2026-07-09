package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Test135
{
	public static void main(String[] args) throws Exception
	{
		//Open existing file in read mode
		File f=new File("src\\test\\resources\\mydata.txt");
		FileReader fr=new FileReader(f);  
		//Load file into RAM as text file  
	    BufferedReader br=new BufferedReader(fr);
	    //Get count of words in each line
	    String line=null;
	    int ln=1;
	    while((line=br.readLine())!=null) //loop terminates after last line's reading
	    {
	    	String pieces[]=line.split(" "); //Separator is blank space
	    	if(ln==1)
	    	{
	    		System.out.println("1st line has "+pieces.length+" words");
	    	}
	    	else if(ln==2)
	    	{
	    		System.out.println("2nd line has "+pieces.length+" words");
	    	}
	    	else if(ln==3)
	    	{
	    		System.out.println("3rd line has "+pieces.length+" words");
	    	}
	    	else
	    	{
	    		System.out.println(ln+"th line has "+pieces.length+" words");
	    	}
	    	ln++; //goto next line
	    }
	    //close file
	    br.close();
	    fr.close();
	}
}
