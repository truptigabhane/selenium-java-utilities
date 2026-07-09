package practice;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class Test163a
{
	public static void main(String[] args) throws Exception
	{
		//Take new Word document in "WRITE" mode
		XWPFDocument doc=new XWPFDocument();  
        XWPFParagraph para=doc.createParagraph();  
        XWPFRun run=para.createRun();  
        run.setText("Hello all, Happy Sunday.");
        //Save in HDD
        File f=new File("src/test/resources/doc1.docx");
		FileOutputStream fo=new FileOutputStream(f);
        doc.write(fo); //save
        doc.close();
        fo.close();
	}
}
