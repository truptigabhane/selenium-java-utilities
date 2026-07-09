package mypack;

public class Dummy10 
{
	public static void main(String[] args)
	{
		Dummy8 obj1=new Dummy9(); //create object to abstract class using child class constructor
		Dummy8.method1(); //call static method
		obj1.method2();
		obj1.method3();

	}

}
