package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Utils.TestContextSetup;
import io.cucumber.java.en.Then;
import pageObjects.CheckoutPage;

public class CheckoutPageStepDefinition {
	
	public WebDriver driver;
	public String OfferPage_ProductName;
	public String productName;
	public CheckoutPage checkoutPage;
	TestContextSetup testContextSetup;
	
	public CheckoutPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
		this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
	}

	@Then("verify user has ability to enter promo code and place the order")
	
	public void verify_user_has_ability_enter_promo() {

	Assert.assertTrue(checkoutPage.VerifyPromoBtn());

	Assert.assertTrue(checkoutPage. VerifyPlaceOrder());

	}

	@Then("^User proceeds to Checkout and validate the (.+) items in checkout pages")
	
	public void user_proceeds_to_checkout(String name) throws InterruptedException
	{
	 
		checkoutPage.CheckoutItems();

	//Assertion to extract name from screen and compare with name

	}

	}
