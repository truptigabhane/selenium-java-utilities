package practice;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Test254
{
	public static void main(String[] args) throws Exception
	{
		//open calculator window(Java Robot only)
		Runtime.getRuntime().exec("calc.exe");
		Thread.sleep(5000);
		//Automate Calculator window
		StringSelection x=new StringSelection("-120");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(x,null);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ADD);
		r.keyRelease(KeyEvent.VK_ADD);
		Thread.sleep(3000);
		StringSelection y=new StringSelection("568");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(y,null);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_EQUALS);
		r.keyRelease(KeyEvent.VK_EQUALS);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_CONTEXT_MENU);
		r.keyRelease(KeyEvent.VK_CONTEXT_MENU);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		String z=(String) Toolkit.getDefaultToolkit().getSystemClipboard()
				                       .getData(DataFlavor.stringFlavor);
		System.out.println(z);
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_F4);
		r.keyRelease(KeyEvent.VK_F4);
		r.keyRelease(KeyEvent.VK_ALT);
	}

}
