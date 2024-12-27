package com.orangehrm.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static Properties properties;

    public static String getConfigProperty(String key){
        return readConfigProperties().getProperty(key);
    }

    public static Properties readConfigProperties(){
        if(properties == null){
            properties = new Properties();
            FileInputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config.properties");
                properties.load(fileInputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return properties;
    }
}
