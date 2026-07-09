package mypack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dummy15
{
    public static void main(String[] args) 
    {
        // Define the command to execute
        String command ="calc"; // Replace with your desired command

        try {
            // Create a process builder for the command
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            
            // Redirect the process output to Java's input/output streams
            processBuilder.redirectErrorStream(true);
            
            // Start the process
            Process process = processBuilder.start();

            // Read the process output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Wait for the process to finish
            int exitCode = process.waitFor();
            System.out.println("Command exited with code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

