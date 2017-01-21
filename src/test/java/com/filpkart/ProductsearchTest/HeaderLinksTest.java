package com.filpkart.ProductsearchTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.Base.TestBase;
import com.flipkart.Pages.HeaderPage;
import com.flipkart.Utils.SeleniumUtils;

public class HeaderLinksTest {


	@BeforeMethod
	public void navigateToHomePage(){
		SeleniumUtils.navigate(TestBase.CONFIG.getProperty("TestURL"));
	}

	@Test(description="Verify if the F-Assured link on header area is not broken")
	public void verifyFAssuredLinkTest(){
		HeaderPage hp= PageFactory.initElements(SeleniumUtils.driver, HeaderPage.class);
		hp.verifyExpectedPageTitle("Flipkart Assured - Quality Products Delivered Fast | Flipkart.com");
	}

}
