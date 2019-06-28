package com.test.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyHandler {
	private final static Properties prop = new Properties();

	static {
		loadProperties();
	}
	
	public static String getPropertyValue(String key) {
		 String value=prop.getProperty(key);
		  return value;
	}
	
	private static void loadProperties() {
		InputStream input = null;
		try {
			input = PropertyHandler.class.getClassLoader().getResourceAsStream("User.properties");

			// load a properties file
			prop.load(input);
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
