package practice;

import java.io.*;
import java.util.zip.*;

import org.testng.annotations.Test;

public class Test129 
{
	@Test
	public void method1() throws Exception
	{
        String zipFilePath="E:\\batch264\\chromedriver-win64.zip";
        String unzipDirectory="E:\\batch264";
        // Create a FileInputStream to read the ZIP file
        FileInputStream fis = new FileInputStream(zipFilePath);
        // Create a ZipInputStream to read the contents of the ZIP file
        ZipInputStream zis = new ZipInputStream(fis);
        // Create a buffer to read data from the ZIP file
        byte[] buffer = new byte[1024];
        // Loop through the entries in the ZIP file
        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) 
        {
             String entryName = entry.getName();
             String entryPath = unzipDirectory + File.separator + entryName;
             // Create directories if they don't exist
             File entryFile = new File(entryPath);
             if (entry.isDirectory()) 
             {
                 entryFile.mkdirs();
             } 
             else 
             {
                  // Create parent directories if they don't exist
                  File parent = entryFile.getParentFile();
                  if (parent != null && !parent.exists()) 
                  {
                       parent.mkdirs();
                  }
                  // Write the entry's data to the file
                  FileOutputStream fos = new FileOutputStream(entryFile);
                  int bytesRead;
                  while ((bytesRead = zis.read(buffer)) != -1) 
                  {
                        fos.write(buffer, 0, bytesRead);
                  }
                  fos.close();
                }
            }
            // Close the ZipInputStream and FileInputStream
            zis.close();
            fis.close();
            System.out.println("Unzip complete.");
    }
}

