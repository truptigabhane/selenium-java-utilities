package mypack;

public abstract class Dummy8 
{
	public int x; //non-static variable
	public static int y=30; //static variable
	public final int w=40; //non-static constant
	public static final int z=20; //static constant
	public Dummy8() //allows constructor
	{
		x=10; //assign a value to non-static variable
	}
	public static void method1() //allows static methods with bodies
	{
		System.out.println(y+" "+z); //access static members only
	}
	public void method2() //allows non-static methods with bodies
	{
		System.out.println(x+" "+w); //access non-static members
		System.out.println(y+" "+z); //access static members
	}
	public abstract void method3(); //allows non-static methods without bodies
}

