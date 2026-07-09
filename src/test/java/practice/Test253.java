package practice;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Iterator;

import org.sikuli.script.Match;
import org.sikuli.script.Screen;

public class Test253
{
	public static void main(String[] args) throws Exception
	{
		//open calculator window(SikuliX with java Robot)
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
		Screen s=new Screen();
		Iterator<Match> l=s.findAll("src\\test\\resources\\images\\add.png");
		l.next().click();
		Thread.sleep(3000);
		StringSelection y=new StringSelection("568");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(y,null);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		s.click("src\\test\\resources\\images\\equals.png");
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_CONTEXT_MENU);
		r.keyRelease(KeyEvent.VK_CONTEXT_MENU);
		Thread.sleep(3000);
		s.click("src\\test\\resources\\images\\copy.png");
		Thread.sleep(3000);
		String z=(String) Toolkit.getDefaultToolkit().getSystemClipboard()
				                       .getData(DataFlavor.stringFlavor);
		System.out.println(z);
		s.click("src\\test\\resources\\images\\closecalc.png");
	}
}
