package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;

public class LandingPageStepDefinition {
		
    public WebDriver driver;
    public String productName;
	public String OfferPage_ProductName;
	TestContextSetup testContextSetup;
	LandingPage landingPage;
	
	public LandingPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}	
	
	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {
		
	    Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
	}
	@When("^User searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortname) throws InterruptedException {
		
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.searchItem(shortname);
		Thread.sleep(2000);
		testContextSetup.productName= landingPage.getProductName().split("-")[0].trim();
	   System.out.println(testContextSetup.productName+ " Extracted from home page");
	   
	}
	
	@When("Added {string} items of the selected product to cart")
	public void Added_items_product(String quantity)
	{
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
	}


}
