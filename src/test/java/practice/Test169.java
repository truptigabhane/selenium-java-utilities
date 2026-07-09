package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class Test169
{
	public static void main(String[] args) throws Exception
	{
		//Update an existing PDF file
		//1. Open an existing PDF file
		File f=new File("src/test/resources/mypdf.pdf");
		//2. Read mode
		FileInputStream fi=new FileInputStream(f);
		PdfReader pr=new PdfReader(fi);
		//3. Write mode
		FileOutputStream fo=new FileOutputStream(f);
		PdfStamper ps=new PdfStamper(pr,fo);
		//4. Get 1st page content
		PdfContentByte content=ps.getUnderContent(1); //pageNumber=1
		//5. Add text to that 1st page content
		Font ft=FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
		Phrase c=new Phrase("please wakeup, otherwise",ft);
		ColumnText ct=new ColumnText(content);
		ct.setSimpleColumn(100,800,800,100);
		ct.setText(c);
		ct.go();
		//6. Add image to that 1st page content
		Image im=Image.getInstance("E:\\myscreenshot.png");
	    im.scaleAbsolute(300, 100);
	    im.setAbsolutePosition(100f, 600f);
	    content.addImage(im);
		ps.close();
	}
}
