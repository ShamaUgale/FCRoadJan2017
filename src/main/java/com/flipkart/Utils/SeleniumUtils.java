package com.flipkart.Utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import com.flipkart.Base.TestBase;

public class SeleniumUtils {

	public static WebDriver driver= TestBase.driver;
	final static Logger logger = Logger.getLogger(SeleniumUtils.class);
 
	
	
	public static void openBrowser(){

		logger.debug("Executing 'open browser' on platform");
		String browser= TestBase.CONFIG.getProperty("browser");
		logger.debug("The browser parameter is -" + browser);
		int implicitWait= Integer.parseInt(TestBase.CONFIG.getProperty("implicitWait"));
		String ffProfile= TestBase.CONFIG.getProperty("FirefoxProfile");
		
		DesiredCapabilities caps= new DesiredCapabilities();
		caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		caps.setCapability(CapabilityType.ENABLE_PERSISTENT_HOVERING, true);
		caps.setCapability(CapabilityType.BROWSER_NAME, browser);
		caps.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
		
		if(browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", TestBase.PROJECT_PATH+"\\src\\main\\resources\\drivers\\chromedriver.exe");
			driver= new ChromeDriver(caps);
		}else if(browser.equalsIgnoreCase("FF")){
			
			ProfilesIni profiles= new ProfilesIni();
			FirefoxProfile fp=profiles.getProfile(ffProfile);
			driver= new FirefoxDriver(fp);
			
			
		}else if(browser.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", TestBase.PROJECT_PATH+"\\src\\main\\resources\\drivers\\IEDriverServer.exe");
			driver= new InternetExplorerDriver(caps);
		}else{
			System.setProperty("webdriver.chrome.driver", TestBase.PROJECT_PATH+"\\src\\main\\resources\\drivers\\chromedriver.exe");
			driver= new ChromeDriver(caps);
		}
		
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
	}
	
	public String getCurrentURL() {

		String url=driver.getCurrentUrl();
		return url;
		
	}
	
	public String getPageSource() {

		String url=driver.getPageSource();
		return url;
		
	}
	
	public static void navigate(String URL){
		driver.navigate().to(URL);
	}
	
	public static void navigateBack(){
		driver.navigate().back();
	}
	
	// navigateForward
	//refreshPage
	
	
	public static void click(WebElement elem){
		elem.click();
	}
	
	public static void type(WebElement elem, String data){
		elem.clear();
		elem.sendKeys(data);
	}
	
	
	// dropdowns - selectbyindex , selectbynameid, selectbyvisibletext, getSelectedOption, getAllDropDownValues
	
	public static void selectByIndex(WebElement elem, int index){
		Select sec= new Select(elem);
		sec.selectByIndex(index);
	}
	
	
	public static List<String> getAllDropDownValues(WebElement elem){
		Select sec= new Select(elem);
		
		List<String> allDropDownValues= new ArrayList<String>();
		
		List<WebElement> allOptions=sec.getOptions();
		
		Iterator<WebElement> it= allOptions.iterator();
		
		while(it.hasNext()){
			String txt= it.next().getText();
			allDropDownValues.add(txt);
			
		}
		
		return allDropDownValues;
		
	}
	
	
	public boolean isElementDisplayed(WebElement elem){
		return elem.isDisplayed();
	}
	
	public boolean verifyElementText(WebElement elem, String expectedText){
		String actualTxt=elem.getText().trim();
		if(actualTxt.equalsIgnoreCase(expectedText)){
			return true;
		}else{
			return false;
		}
	}
	
	
	public boolean verifyExpectedPageTitle(String expectedTitle) {

		String actualTitle=driver.getTitle().trim();
		if(actualTitle.equalsIgnoreCase(expectedTitle)){
			return true;
		}else{
			return false;
		}
		
	}
	
	
	
	
	
}
