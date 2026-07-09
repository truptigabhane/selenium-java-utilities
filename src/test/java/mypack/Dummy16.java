package mypack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dummy16
{
    public static void main(String[] args) 
    {
        try 
        {
            // Change the working directory to the specified path
            String workingDirectory = "E:\\batch263API\\simpleprojectgitcmd";
            ProcessBuilder changeDirProcessBuilder = new ProcessBuilder("cmd.exe", "/c", "cd", workingDirectory);
            changeDirProcessBuilder.redirectErrorStream(true);
            Process changeDirProcess = changeDirProcessBuilder.start();
            changeDirProcess.waitFor();

            // Run Maven test command
            String mavenTestCommand = "mvn test -Dtest=Test1.java";
            ProcessBuilder mavenProcessBuilder = new ProcessBuilder("cmd.exe", "/c", mavenTestCommand);
            mavenProcessBuilder.directory(new java.io.File(workingDirectory));
            mavenProcessBuilder.redirectErrorStream(true);
            Process mavenProcess = mavenProcessBuilder.start();

            // Print output of Maven command
            BufferedReader reader = new BufferedReader(new InputStreamReader(mavenProcess.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Wait for the Maven process to finish
            int mavenExitCode = mavenProcess.waitFor();
            System.out.println("Maven command exited with code: " + mavenExitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
