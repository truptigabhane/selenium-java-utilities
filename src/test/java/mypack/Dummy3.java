package mypack;

public class Dummy3 
{
	public static void main(String[] args)
	{
		String s1=new String("Sachin"); //as an object
		String s2=new String("Sachin"); //as an object
		System.out.println(s1);
		if(s1==s2) //compare memory addresses of 2 objects
		{
			System.out.println("same"); 
		}
		else
		{
			System.out.println("not same"); 
		}
		if(s1.equals(s2)) //compare values refereed by 2 objects
		{
			System.out.println("same"); 
		}
		else
		{
			System.out.println("not same"); 
		}
	}
}
