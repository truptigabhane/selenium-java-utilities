package mypack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileWriter;

public class Dummy17
{
    public static void main(String[] args) 
    {
        try 
        {
            String workingDirectory = "E:\\batch263API\\simpleprojectgitcmd";
            String outputFilePath = "E:\\batch263API\\simpleprojectgitcmd\\output.txt"; 
            
            // Change the working directory
            ProcessBuilder changeDirProcessBuilder = new ProcessBuilder("cmd.exe", "/c", "cd", workingDirectory);
            Process changeDirProcess = changeDirProcessBuilder.start();
            changeDirProcess.waitFor();

            // Run Maven test command and redirect output to file
            String mavenTestCommand = "mvn test -Dtest=Test1.java";
            ProcessBuilder mavenProcessBuilder = new ProcessBuilder("cmd.exe", "/c", mavenTestCommand);
            mavenProcessBuilder.directory(new java.io.File(workingDirectory));
            mavenProcessBuilder.redirectErrorStream(true);
            Process mavenProcess = mavenProcessBuilder.start();
            
            // Redirect output to file
            BufferedReader reader = new BufferedReader(new InputStreamReader(mavenProcess.getInputStream()));
            FileWriter fileWriter = new FileWriter(outputFilePath);
            String line;
            while ((line = reader.readLine()) != null) {
                fileWriter.write(line + "\n");
            }
            fileWriter.close();

            // Wait for the Maven process to finish
            int mavenExitCode = mavenProcess.waitFor();
            System.out.println("Maven command exited with code: " + mavenExitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

