package practice;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;

public class Test163b 
{
    public static void main(String[] args) throws Exception
    {
        XWPFDocument doc=new XWPFDocument();
        // Create a centred heading
        XWPFParagraph title=doc.createParagraph();
        title.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titleRun=title.createRun();
        titleRun.setText("Selenium WebDriver JAVA");
        titleRun.setBold(true);
        titleRun.setFontSize(16);
        // Create a paragraph with italicised text
        XWPFParagraph para=doc.createParagraph();
        XWPFRun run=para.createRun();
        run.setText("This is a Web site functional test automation library.");
        run.setItalic(true);
        run.setFontSize(11);
        //Save in HDD
        File f=new File("src/test/resources/doc2.docx");
		FileOutputStream fo=new FileOutputStream(f);
        doc.write(fo); //save 
        doc.close();
        fo.close();
    }
}

