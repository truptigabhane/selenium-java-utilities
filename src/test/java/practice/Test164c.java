package practice;

import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

public class Test164c 
{
    public static void main(String[] args) throws Exception
    {
    	File f=new File("src/test/resources/doc4.docx");
		FileInputStream fi=new FileInputStream(f);
        XWPFDocument doc=new XWPFDocument(fi);
        // Specify the index of the table containing the target row (zero-based)
        int ti=0; // 1st table
        int ri=1; // 2nd row
        int ci=2; //3rd column
        List<XWPFTable> tables=doc.getTables();
        XWPFTable targetTable=tables.get(ti);
        List<XWPFTableRow> rows=targetTable.getRows();
        XWPFTableRow targetRow=rows.get(ri);
        List<XWPFTableCell> cells=targetRow.getTableCells();
        System.out.println(cells.get(ci).getText());
        doc.close();
        fi.close();
    }
}

