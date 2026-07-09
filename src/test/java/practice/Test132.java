package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Test132
{
	public static void main(String[] args) throws Exception
	{
		//Open existing file in read mode
		File f=new File("src\\test\\resources\\mydata.txt");
		FileReader fr=new FileReader(f);  
		//Load file from HDD into RAM as a text file  
	    BufferedReader br=new BufferedReader(fr);
	    //Get count of lines in text file
	    int count=0;
	    String line="";
	    while((line=br.readLine())!=null) //loop terminates after last line's reading
	    {
	    	count++;
	    }
	    System.out.println("Count of lines in file is "+count);
	    //close file
	    br.close();
	    fr.close();
	}
}
