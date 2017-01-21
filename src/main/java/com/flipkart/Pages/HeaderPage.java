package com.flipkart.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.flipkart.Utils.SeleniumUtils;

public class HeaderPage extends SeleniumUtils{

	
	
	
	
	
	// elemnets
	
	@FindBy(name="q")
	public static WebElement searchTxtBox;
	
	@FindBy(xpath="//button[@class='vh79eN' and @type='submit']")
	public static WebElement searchbtn;
	
	@FindBy(linkText="F-Assured")
	public static WebElement FAssuredLink;
	
	
	
	
	
	// features
	
	
	public void searchProduct(String productName){
		type(searchTxtBox, productName);
		click(searchbtn);
	}
	
	
	public boolean isFAssuredPageDisplayed(String expectedTitle){
		click(FAssuredLink);
		return verifyExpectedPageTitle(expectedTitle);
		
	}


	
	
	
}
