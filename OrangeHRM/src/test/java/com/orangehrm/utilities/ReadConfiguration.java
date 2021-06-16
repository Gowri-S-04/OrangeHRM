package com.orangehrm.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfiguration {

	Properties p;

	public ReadConfiguration() {
		File readconfig = new File("./Configuration\\config.properties");

		try {
			FileInputStream fis = new FileInputStream(readconfig);
			p = new Properties();
			p.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getApplicationURL() {
		String url = p.getProperty("baseURL");
		return url;
	}

	public String getChromePath() {
		String chromepath = p.getProperty("chromepath");
		return chromepath;
	}

	public String getFirefoxPath() {
		String firefoxpath = p.getProperty("firefoxpath");
		return firefoxpath;
	}

	public String getEdgePath() {
		String edgepath = p.getProperty("edgepath");
		return edgepath;
	}
}
