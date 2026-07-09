package mypack;

import java.util.List;

import org.sikuli.script.ImagePath;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

public class SikuliTest
{
	public static void main(String[] args) throws Exception
	{
		Thread.sleep(5000);
		ImagePath.add(System.getProperty("user.dir")); //current project
		Screen s=new Screen();
		s.click("src\\test\\resources\\images\\minimise.png");
		Thread.sleep(5000);
		s.doubleClick("src\\test\\resources\\images\\recyclebin.png");
		Thread.sleep(5000);
		List<Match> m=s.findAllList("src\\test\\resources\\images\\pc.png");
		m.get(0).click(); //click on 1st matched element

	}

}
