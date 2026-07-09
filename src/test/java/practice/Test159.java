package practice;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test159
{
	public static void main(String[] args) throws Exception
	{
		//Take new Excel file with a sheet
		File f=new File("src/test/resources/Book1.xlsx");
		XSSFWorkbook wwb=new XSSFWorkbook(); 
		Sheet wsh;
		try
		{
			wsh=wwb.createSheet("Sheet1");
		}
		catch(Exception ex) //if already exist
		{
			wsh=wwb.getSheet("Sheet1");
		}
		// Define style to decorate a cell  
		CellStyle style=wwb.createCellStyle();  
        style.setFillBackgroundColor(IndexedColors.YELLOW.getIndex());  
        style.setFillPattern(FillPatternType.LEAST_DOTS);
        //Add that style to target cell
        Cell cell=wsh.createRow(0).createCell(0);  
        cell.setCellValue("Hi Students");  
        cell.setCellStyle(style); 
        wsh.autoSizeColumn(0);
        //Save excel file
      	FileOutputStream fo=new FileOutputStream(f); //WRITE mode(Appending)
      	wwb.write(fo);
      	fo.close();
      	wwb.close();
	}
}
