package practice;

import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Test166
{
	public static void main(String[] args) throws Exception
	{
		File f=new File("src/test/resources/myparas.pdf");
		FileOutputStream fo=new FileOutputStream(f);
		//Add text in multiple paragraphs a new pdf file
		Document doc=new Document();
		PdfWriter.getInstance(doc,fo);
		doc.open();
		
		Paragraph p1=new Paragraph();
		p1.add("Hi");
		doc.add(p1);
		
		Paragraph p2=new Paragraph();
		p2.add("How are you?");
		doc.add(p2);
		
		Paragraph p3=new Paragraph();
		p3.add("Bye");
		doc.add(p3);
		
		doc.close();
	}
}
