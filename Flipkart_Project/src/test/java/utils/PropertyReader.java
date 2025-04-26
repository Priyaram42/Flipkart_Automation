package utils;

import java.io.FileInputStream;

import java.io.IOException;

import java.util.Properties;

public class PropertyReader {

	static String filename = ".\\src\\test\\resources\\config\\config.properties";

	static FileInputStream fis;

	static Properties prop;

	public static Properties readProperty() {

		try {

			fis = new FileInputStream(filename);
			prop = new Properties();
			prop.load(fis);
		} catch (IOException e) {
			System.out.println("File path or File name is not correct");
			e.printStackTrace();
		}

		return prop;
	}

}