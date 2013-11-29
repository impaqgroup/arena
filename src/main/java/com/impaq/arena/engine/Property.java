package com.impaq.arena.engine;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Property {

    private Properties properties = new Properties();

    public String getProperty(String propertyName) {
        InputStream is = this.getPropertyInputStream();
        try {
            properties.load(is);
        } catch (IOException ioe) {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ex) {
                }
            }
            throw new RuntimeException("property file i/o exception.");
        }
        return properties.getProperty(propertyName);
    }

    private InputStream getPropertyInputStream() {
        return getClass().getClassLoader().getResourceAsStream("arena.properties");
    }

}
