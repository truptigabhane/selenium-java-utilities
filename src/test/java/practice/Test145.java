package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Test145
{
	public static void main(String[] args) throws Exception
	{
		//Open an existing file in READ mode
		File f1=new File("src\\test\\resources\\myvalues.txt");
		FileReader fr=new FileReader(f1);  
	    BufferedReader br=new BufferedReader(fr);
	    //Take a new file in WRITE mode
	    File f2=new File("src\\test\\resources\\myoutput.txt");
	    FileWriter fw=new FileWriter(f2,true); //for append
	    BufferedWriter bw=new BufferedWriter(fw);
	    //Get each line
	    String line="";
	    while((line=br.readLine())!=null) //loop terminates after last line's reading
	    {
	    	String[] pieces=line.split(",");
	    	int input1=Integer.parseInt(pieces[0]);
	    	int input2=Integer.parseInt(pieces[2]);
	    	if(pieces[1].equalsIgnoreCase("add"))
	    	{
	    		String temp=""+(input1+input2);
	    		bw.write(temp);
	    		bw.newLine();
	    	}
	    	else if(pieces[1].equalsIgnoreCase("subtract"))
	    	{
	    		String temp=""+(input1-input2);
	    		bw.write(temp);
	    		bw.newLine();
	    	}
	    	else if(pieces[1].equalsIgnoreCase("multiply"))
	    	{
	    		String temp=""+(input1*input2);
	    		bw.write(temp);
	    		bw.newLine();
	    	}
	    	else
	    	{
	    		String temp=""+(float)input1/(float)input2;
	    		bw.write(temp);
	    		bw.newLine();
	    	}
	    }
	    //close 1st file
	    br.close();
	    fr.close();
	    //close 2nd file
	    bw.close();
	    fw.close();
	}
}
