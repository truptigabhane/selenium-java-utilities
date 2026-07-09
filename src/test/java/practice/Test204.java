package practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test204
{
	public static void main(String[] args) throws Exception
	{
		//search for target word in given text using Regexp
		String x="India won 2nd World cup in india in 2011 for 150 crore people";
		Pattern p=Pattern.compile("[A-Z][a-z]+");
		Matcher m=p.matcher(x);
		//Get count of target word's occurrences 
		int noow=0;
		while(m.find())
		{
			noow++;
			System.out.println(m.group());
		}
		System.out.println("Total count of results is "+noow);
	}
}
