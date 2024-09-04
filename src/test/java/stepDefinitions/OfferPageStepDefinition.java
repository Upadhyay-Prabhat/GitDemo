package stepDefinitions;


import org.testng.Assert;

import Utils.TestContextSetup;
import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OfferPage;
import pageObjects.PageObjectManager;


public class OfferPageStepDefinition {
	

	public String OfferPage_ProductName;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	
	public OfferPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
	}
	
	@Then("^user searched for (.+) Shortname in offer page$")
	public void user_searched_with_same_shortname_in_offer_page(String Shortname) throws InterruptedException {
		   switchToOffersPage();
		   OfferPage offerPage = testContextSetup.pageObjectManager.getOfferPage();
		   offerPage.searchItem(Shortname);
		   Thread.sleep(2000);
		   OfferPage_ProductName = offerPage.getproductName();
	    
	}
	
	public void switchToOffersPage() {
		
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDealsPage();
		testContextSetup.genericUtils.switchWindowToChild();

	}
	
	@Then("validate product name in offers page match with landing page")
	public void validate_product_name_in_offers_page_match_with_landing_page() {
		Assert.assertEquals(OfferPage_ProductName , testContextSetup.productName);
	}

}
