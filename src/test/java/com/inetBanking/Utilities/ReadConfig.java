package com.inetBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	
	public ReadConfig() {
		
		File src =  new File("./Configuration\\Config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);// to read config file from File
			pro = new  Properties();
			pro.load(fis);
			
		}
		catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicationURL() {
		String url= pro.getProperty("baseURL");
		return url;
	}
	public String getUsername() {
		String username= pro.getProperty("username");
		return username;
	}
	public String getPassword() {
		String password= pro.getProperty("password");
		return password;
	}
	public String getChromepath() {
		String Chromepath= pro.getProperty("Chromepath");
		return Chromepath;
	}
	public String getFirepath() {
		String Firepath= pro.getProperty("Firepath");
		return Firepath;
	}
	
	
	
	 
	
}
