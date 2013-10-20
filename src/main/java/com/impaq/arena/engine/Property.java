package com.impaq.arena.engine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Property {

	private Properties properties = new Properties();
	
	public String getProperty(String propertyName) {
			FileInputStream is = this.getPropertyInputStream();
			try {
				properties.load(is);
			} catch ( IOException ioe ) {
				throw new RuntimeException("property file i/o exception.");
			}
			return properties.getProperty(propertyName);
	}
	
	private FileInputStream getPropertyInputStream() {
		try {
			File propertyFile = new File( new File(".").getCanonicalPath() +"\\src\\main\\resource\\arena.properties");
			return new FileInputStream(propertyFile);
		} catch ( FileNotFoundException fnfe ) {
			throw new RuntimeException("property file doesn't exist.");
		} catch ( IOException ioe ) {
			throw new RuntimeException("property file i/o exception.");
		}
	}
	
}
