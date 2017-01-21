package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.lift.find.InputFinder;

public class PropertyFiles {

	
	public static void main(String[] args) throws IOException {

		String projectpath= System.getProperty("user.dir");
		System.out.println(projectpath);
		
		
		Properties config= new Properties();
		
		FileInputStream ip= new FileInputStream(new File(projectpath+"\\src\\main\\resources\\config\\config.properties"));
		
		config.load(ip);
		
		
		
		
		System.out.println(config.get("Password"));
		
		
	}

}
