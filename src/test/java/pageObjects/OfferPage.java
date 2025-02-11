package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage {
	
	public WebDriver driver;
	
	public OfferPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	By search = By.xpath("//input[@type=\"search\"]");
	By productName = By.xpath("//td[text()='Tomato']");
	
	public void searchItem(String name) 
	
	{
	  driver.findElement(search).sendKeys(name);	
	}
	
	public void getSearchText()
	{
		driver.findElement(search).getText();
	}
	
    public String getproductName() 
	
	{
	  return driver.findElement(productName).getText();	
	}

}
