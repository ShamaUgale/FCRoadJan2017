package com.flipkart.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.flipkart.Utils.SeleniumUtils;

public class ProductListingPage extends SeleniumUtils{

	
	@FindBy(xpath="//span[@class='W-gt5y']")
	WebElement searchedForText;
	
	
	public boolean verifySearchedTextForIsDisplayed(){
		return isElementDisplayed(searchedForText);
	}
	
	public boolean verifySearchedText(String expectedText){
		return verifyElementText(searchedForText, expectedText);
	}
	
	
	
}
