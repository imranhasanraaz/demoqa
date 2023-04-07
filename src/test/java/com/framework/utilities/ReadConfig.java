package com.framework.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	private static Properties properties;

	String path = "./Configuration/config.properties";

	public ReadConfig() {
		try {
			properties = new Properties();
			FileInputStream fis = new FileInputStream(path);
			properties.load(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getBaseUrl() {
		String value = properties.getProperty("baseUrl");

		if (value != null)
			return value;
		else
			throw new RuntimeException("url not specified in config file.");

	}

	public String getBrowser() {
		String value = properties.getProperty("browser");

		if (value != null)
			return value;
		else
			throw new RuntimeException("browser not specified in config file.");

	}

	public String getTimeout() {
		String value = properties.getProperty("timeout");

		if (value != null)
			return value;
		else
			throw new RuntimeException("timeout not specified in config file.");

	}

}