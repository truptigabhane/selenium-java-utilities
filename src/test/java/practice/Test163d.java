package practice;

import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;

public class Test163d 
{
    public static void main(String[] args) throws Exception
    {
        XWPFDocument doc=new XWPFDocument();
        // Create a table with 3 rows and 3 columns
        int numRows = 3;
        int numCols = 3;
        XWPFTable table=doc.createTable(numRows, numCols);
        // Set table width (optional)
        table.setWidth("100%");
        // Iterate over the rows and columns to set cell content
        for (int row = 0; row < numRows; row++) 
        {
            XWPFTableRow tableRow = table.getRow(row);
            for (int col = 0; col < numCols; col++) 
            {
                XWPFTableCell tableCell = tableRow.getCell(col);
                XWPFParagraph paragraph = tableCell.addParagraph();
                XWPFRun run = paragraph.createRun();
                run.setText("Row " + (row + 1) + ", Column " + (col + 1));
            }
        }
        // Save the document to a file
        File f=new File("src/test/resources/doc4.docx");
		FileOutputStream fo=new FileOutputStream(f);
        doc.write(fo); 
        doc.close();
        fo.close();
    }
}

