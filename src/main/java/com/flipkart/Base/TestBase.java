package com.flipkart.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class TestBase {

	public static WebDriver driver=null;
	public static Properties CONFIG=null;
	public static final String PROJECT_PATH= System.getProperty("user.dir");
	final static Logger logger = Logger.getLogger(TestBase.class);
	
	public static void initFiles() throws IOException{
		try{
		if(CONFIG==null){
		CONFIG= new Properties();
		FileInputStream ip= new FileInputStream(new File("C:\\Users\\shama.ugale\\workspace\\FCWeekendsNOV_POM_Framework\\src\\main\\resources\\config\\config.properties"));
		CONFIG.load(ip);
		logger.debug("ALl the required project properties are loaded successfully");
		}
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		
	}
	
	
	
	
	
}
