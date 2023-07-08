
package com.mery.youtubevideodownloader.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author emirs
 */
public class Config {
    public static String downloadLocation;
    public static String pyModuleLocation;
    public static String interpreterLocation;

    
    public static void updateConfigFile(String downloadLocation, String pyModuleLocation, String interpreterLocation){
        String filename = System.getProperty("user.dir") + "\\settings\\config.txt";

        try {
            FileWriter fileWriter = new FileWriter(filename, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(downloadLocation);
            bufferedWriter.newLine();
            bufferedWriter.write(pyModuleLocation);
            bufferedWriter.newLine();
            bufferedWriter.write(interpreterLocation);
            bufferedWriter.newLine();

            bufferedWriter.close();
            System.out.println("Content written to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
        
        Config.downloadLocation = downloadLocation;
        Config.pyModuleLocation = pyModuleLocation;
        Config.interpreterLocation = interpreterLocation;
    }
    
    public static void getConfigsFromFile(){
        String filename = System.getProperty("user.dir") + "\\settings\\config.txt";

        ArrayList<String> lines = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
        
        downloadLocation = lines.get(0);
        pyModuleLocation = lines.get(1);
        interpreterLocation = lines.get(2);
    }
    
    public static void initConfigFileWithDefaultOptions(){
        updateConfigFile("", System.getProperty("user.dir") + "\\PythonDownloder\\" ,"python");
        getConfigsFromFile();
    }
    
    public static boolean isConfigFileExist(){
        String filePath = System.getProperty("user.dir") + "\\settings\\config.txt";
        
        Path file = Paths.get(filePath);
        return Files.exists(file);
    }
    
    
}
