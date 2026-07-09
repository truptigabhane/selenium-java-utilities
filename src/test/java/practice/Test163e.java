package practice;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Test163e 
{
    public static void main(String[] args) throws Exception
    {
        XWPFDocument doc=new XWPFDocument();
        // Create a paragraph to add the image
        XWPFParagraph para=doc.createParagraph();
        // Add a run to the paragraph
        XWPFRun run=para.createRun();
        // Specify the path to the image file
        String imagePath = "target\\myelement.png"; 
        // Load the image file into an InputStream
        InputStream imageStream = Files.newInputStream(Path.of(imagePath));
        // Add the image to the run
        run.addPicture(imageStream, XWPFDocument.PICTURE_TYPE_PNG, "myelement.png", Units.toEMU(200), Units.toEMU(100));
        // Parameters: InputStream, Picture Type (JPEG, PNG, etc.), Image Filename, Width, Height
        // Close the InputStream
        imageStream.close();
        // Save the document to a file
        File f=new File("src/test/resources/doc5.docx");
		FileOutputStream fo=new FileOutputStream(f);
        doc.write(fo); 
        doc.close();
        fo.close();
    }
}

