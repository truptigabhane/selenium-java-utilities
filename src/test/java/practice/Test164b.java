package practice;

import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

public class Test164b 
{
    public static void main(String[] args) throws Exception
    {
    	File f=new File("src/test/resources/doc1.docx");
		FileInputStream fi=new FileInputStream(f);
        XWPFDocument doc=new XWPFDocument(fi);
        // Specify the index of the paragraph you want to retrieve (zero-based)
        int paraindex=0; // Change this to the desired index
        // Get all paragraphs in the document
        List<XWPFParagraph> paras=doc.getParagraphs();
        if (paraindex >= 0 && paraindex < paras.size()) 
        {
            // Retrieve the specific paragraph
            XWPFParagraph specificParagraph=paras.get(paraindex);
            System.out.println(specificParagraph.getText());
        } 
        else 
        {
        	System.out.println("Invalid paragraph index.");
        }
        doc.close();
        fi.close();
    }
}

