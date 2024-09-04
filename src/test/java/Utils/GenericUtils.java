package Utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	
	public WebDriver driver;
	
	public GenericUtils(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void switchWindowToChild()
	{
		Set<String> windows= driver.getWindowHandles();
		   Iterator<String> id=windows.iterator();
		   String parentWindow = id.next();
		   String childWindow = id.next();
		   driver.switchTo().window(childWindow);
	}

}
