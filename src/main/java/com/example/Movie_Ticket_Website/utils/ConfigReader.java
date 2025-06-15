package com.example.Movie_Ticket_Website.utils;

import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        try {
            var inputStream = ConfigReader.class.getClassLoader().getResourceAsStream("properties.env");
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                System.err.println("Không tìm thấy file properties.env trong resources.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}

