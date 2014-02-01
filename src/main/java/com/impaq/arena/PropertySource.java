package com.impaq.arena;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertySource {

    private Properties properties = new Properties();

    public void load() {
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
    }

    public String getString(String propertyName) {
        return properties.getProperty(propertyName);
    }

    public Double getDouble(String propertyName) {
        return Double.valueOf(getString(propertyName));
    }

    public Integer getInt(String propertyName) {
        return Integer.valueOf(getString(propertyName));
    }

    private InputStream getPropertyInputStream() {
        return getClass().getClassLoader().getResourceAsStream("arena.properties");
    }

}
