package mypack;

public class Dummy1 
{
	public static void main(String[] args)
	{
		Integer x=new Integer("10");
		Integer y=new Integer(20);
		Integer z=new Integer(x.intValue()+y.intValue());
		System.out.println(z.intValue());
	}
}
