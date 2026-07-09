package practice;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test4 
{
	public static void main(String[] args)
	{
		//1. download and use specific version of driver software
		WebDriverManager obj1=WebDriverManager.chromedriver();
		WebDriverManager obj2=obj1.driverVersion("112.0.5615.49");
		obj2.setup();
		//2. download browser driver which suitable to given browser version
		WebDriverManager.chromedriver().browserVersion("112").setup();
		//3. download and use specific version of driver software in 64-bit
		WebDriverManager.chromedriver().driverVersion("112.0.5615.49").arch64().setup();
	}

}
