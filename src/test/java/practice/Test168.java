package practice;

import java.io.File;
import java.io.FileInputStream;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class Test168
{
	public static void main(String[] args) throws Exception
	{
		//Open an existing PDF file 1 in READ mode
		File f1=new File("E:\\example-user-stories1.pdf");
		FileInputStream fi1=new FileInputStream(f1);
		PdfReader pr1=new PdfReader(fi1);
		int n1=pr1.getNumberOfPages();
		//Open an existing PDF file 2 in READ mode 
        File f2=new File("E:\\example-user-stories2.pdf");
		FileInputStream fi2=new FileInputStream(f2);
		PdfReader pr2=new PdfReader(fi2);
		int n2=pr2.getNumberOfPages();
		if(n1!=n2)
		{
			System.out.println("Both files are not suitable to compare");
		}
		else   //n1 equals to n2
		{
			//Loop to compare two files page wise
			for(int i=1;i<=n1;i++)
			{
				String x=PdfTextExtractor.getTextFromPage(pr1,i);
				String y=PdfTextExtractor.getTextFromPage(pr2,i);
				//compare
				if(x.equalsIgnoreCase(y))
				{
					System.out.println("Both files have same content in "+i+" page");
				}
				else
				{
					System.out.println("Both files have different content in "+i+" page");
				}
			}
		}
		pr1.close();
		pr2.close();
	}
}
