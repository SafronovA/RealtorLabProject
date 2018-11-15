
package com.epam.tat.realtor.util;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.stream.Stream;

public class ConfigProperties {

    private static FileInputStream fileInputStream;
    private static Properties PROPERTIES;

    static {
        try {
            fileInputStream = new FileInputStream("src/main/resources/farm.properties");
//            fileInputStream = new FileInputStream("src/main/resources/mate.properties");
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    /**
     * get property value from config.properties
     *
     * @param key key from config.properties
     * @return value of key
     */
    public static String getTestProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
//
    //////

//
//    private static FileInputStream fileInputStream;
//    private static Properties properties;
//
//    static {
//        try {
//            fileInputStream = new FileInputStream("src/main/resources/config.properties");
//            properties = new Properties();
//            properties.load(fileInputStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (fileInputStream != null)
//                try {
//                    fileInputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//        }
//    }
//
//    public static String getTestProperty(String key) {
//        return properties.getProperty(key);
//    }
//
//    public static void setAndroidDeviceCapabilities(DesiredCapabilities capabilities, String filename) {
//        String fileName = "src/main/resources/" + filename + ".properties";
//        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
//            stream.forEach(x -> {
//                String[] parts = x.split("=");
//                capabilities.setCapability(parts[0], parts[1]);
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}

