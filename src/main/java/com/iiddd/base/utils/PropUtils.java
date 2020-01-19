package com.iiddd.base.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropUtils {

    private static String prop = null;

    public static String readPropertyByKey(String key) {
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream(System.getProperty("properties.path"));
            property.load(fis);
            prop = property.getProperty(key);

        } catch (IOException e) {
            System.err.println("Unable to read from properties file");
        }
        return prop;
    }
}
