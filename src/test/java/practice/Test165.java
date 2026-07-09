package practice;

import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;

public class Test165
{
	public static void main(String[] args) throws Exception
	{
		//Add text into a new pdf file
		File f=new File("src/test/resources/mypdf.pdf");
		FileOutputStream fo=new FileOutputStream(f);
		Document doc=new Document();
		PdfWriter.getInstance(doc,fo);
		doc.open();
		Font ft=FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
		Chunk c=new Chunk("Hello friends, are you feeling sleepy?", ft);
		doc.add(c);
		doc.close();
	}
}
