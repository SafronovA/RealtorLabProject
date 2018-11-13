package com.epam.tat.realtor.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreator {
    public static void create(String fileContent) {
        String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/test/resources/propertyList.txt";
        FileWriter fileWriter ;
        try {
            fileWriter = new FileWriter(reportDirectory);
            fileWriter.write(fileContent);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
