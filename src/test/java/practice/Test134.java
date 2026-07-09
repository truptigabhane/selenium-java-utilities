package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Test134
{
	public static void main(String[] args) throws Exception
	{
		//Open existing file in read mode
		File f=new File("src\\test\\resources\\mydata.txt");
		FileReader fr=new FileReader(f);  
		//Load file into RAM as text file  
	    BufferedReader br=new BufferedReader(fr);
	    //Get and display 1st line, 3rd line and 4th line only
	    int count=0;
	    String line="";
	    while((line=br.readLine())!=null) //loop terminates after last line's reading
	    {
	    	count++;
	    	if(count==1 || count==3 || count==4)
	    	{
	    		System.out.println(line);
	    	}
	    }
	    //close file
	    br.close();
	    fr.close();
	}
}
