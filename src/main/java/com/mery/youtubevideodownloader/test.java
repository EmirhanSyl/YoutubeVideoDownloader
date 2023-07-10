package com.mery.youtubevideodownloader;

import com.mery.youtubevideodownloader.core.Config;
import com.mery.youtubevideodownloader.customcomponents.CCDownloadableItem;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author emirs
 */
public class test {

    public static void main(String[] args) {
        //executeDownloadCommand();
        //Config.updateConfigFile("", System.getProperty("user.dir") + "\\PythonDownloder\\", "E:\\Anaconda\\python.exe");
        //Config.getConfigsFromFile();
        //System.out.println(Config.downloadLocation);
        //System.out.println(Config.interpreterLocation);
        //System.out.println(Config.pyModuleLocation);
        
        executeMergeCommand();
    }

    private static void executeDownloadCommand() {

        String filePath = "C:\\Users\\emirs\\Documents\\NetBeansProjects\\YoutubeVideoDownloader\\PythonDownloder\\testW.py";

        // Create a Path object from the file path
        Path file = Paths.get(filePath);

        // Check if the file exists
        boolean fileExists = Files.exists(file);
        System.out.println("File exists: " + fileExists);

        // Check if the file is readable
        boolean isReadable = Files.isReadable(file);
        System.out.println("File is readable: " + isReadable);

        // Check if the file is writable
        boolean isWritable = Files.isWritable(file);
        System.out.println("File is writable: " + isWritable);

        // Check if the file is executable
        boolean isExecutable = Files.isExecutable(file);
        System.out.println("File is executable: " + isExecutable);

        try {
            //String command = "E:\\Anaconda\\python.exe C:\\Users\\emirs\\Documents\\NetBeansProjects\\YoutubeVideoDownloader\\PythonDownloder\\mainDownloader.py --videourl \"https://www.youtube.com/watch?v=Z4Rs8wFOE_A\"";
            String command = "python C:\\Users\\emirs\\Documents\\NetBeansProjects\\YoutubeVideoDownloader\\PythonDownloder\\testW.py";
            Runtime runtime = Runtime.getRuntime();
            System.out.println(command);
            Process process = runtime.exec(command);

            // Read the output from the process
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Wait for the process to finish
            try {
                int exitCode = process.waitFor();
                System.out.println("Exit Code: " + exitCode);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException ex) {
            Logger.getLogger(CCDownloadableItem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void executeMergeCommand() {
        String command = "E:\\Anaconda\\python.exe C:\\Users\\emirs\\Documents\\NetBeansProjects\\YoutubeVideoDownloader\\PythonDownloder\\\\merger.py --videoPath \"C:\\Users\\emirs\\Desktop\\Making 5 Things from a Broken Hair Dryer_248.webm\" --audioPath \"C:\\Users\\emirs\\Desktop\\Making 5 Things from a Broken Hair Dryer_251.webm\" --outputPath \"C:\\Users\\emirs\\Desktop\\Merged_Making 5 Things from a Broken Hair Dryer_248.mp4\"";

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(command.split("\\s+"));
            Process process = processBuilder.start();

            readFile(new InputStreamReader(process.getInputStream()));
            readFile(new InputStreamReader(process.getErrorStream()));

            // Wait for the process to finish
            int exitCode = process.waitFor();
            System.out.println("Exit Code: " + exitCode);

            if (exitCode == 0) {
                System.out.println("Success!");
            } else {
                System.out.println("Error!");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            Logger.getLogger(CCDownloadableItem.class.getName()).log(Level.SEVERE, null, e);
        }

    }
    
    private static void readFile(Reader in) throws IOException {
        BufferedReader reader = new BufferedReader(in);
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
