package utils;

import org.openqa.selenium.WebElement;

public class BasePage extends DriverFactory{
	
	public void click(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
