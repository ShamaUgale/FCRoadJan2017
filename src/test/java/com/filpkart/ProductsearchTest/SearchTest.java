package com.filpkart.ProductsearchTest;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.flipkart.Base.TestBase;
import com.flipkart.Pages.HeaderPage;
import com.flipkart.Pages.ProductListingPage;
import com.flipkart.Utils.FileUtils;
import com.flipkart.Utils.SeleniumUtils;

public class SearchTest {

	@BeforeSuite
	public void setUP() throws IOException{
		TestBase.initFiles();
		SeleniumUtils.openBrowser();
		SeleniumUtils.navigate(TestBase.CONFIG.getProperty("TestURL"));
	}
	
	
	
	@Test(description="verify serach functionality from header search option", dataProvider="getSearchData")
	public void searchProductTest(String ProductName){
		HeaderPage hp= PageFactory.initElements(SeleniumUtils.driver, HeaderPage.class);
		hp.searchProduct(ProductName);
		
		ProductListingPage pl= PageFactory.initElements(SeleniumUtils.driver, ProductListingPage.class);
		boolean isTextDisplayed=pl.verifySearchedTextForIsDisplayed();
		boolean isTextDisplayedCorrectly= pl.verifySearchedText(ProductName);
		
		
		Assert.assertTrue(isTextDisplayed, "The search text is not displayed on the product listing page");
		Assert.assertTrue(isTextDisplayedCorrectly, "The search text is not displayed correctly on the product listing page");
		
	}

	
	
	@DataProvider
	public Object[][] getSearchData(){
		return FileUtils.getData(TestBase.PROJECT_PATH+"\\src\\test\\resources\\com\\flipkart\\Header\\SearchProduct.xlsx", "Search");
	}

}
