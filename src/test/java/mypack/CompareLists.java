package mypack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CompareLists 
{
	public static void main(String[] args)
	{
		String x[]= {"india", "batch264", "selenium", "api", "US"};
		String y[]= {"batch264", "selenium", "india", "US"};
		List<String> l1=Arrays.asList(x);
		List<String> l2=Arrays.asList(y);
		Set<String> intersect=new HashSet<String>(l1);
	    intersect.retainAll(l2);
	    System.out.println(l1.size());
	    System.out.println(l2.size());
	    System.out.println(intersect.size());
	    if(l1.size()==l2.size() && intersect.size()==l1.size())
	    {
	    	System.out.println("both are same");
	    }
	    else
	    {
	    	System.out.println("both are different");
	    }
	}
}
