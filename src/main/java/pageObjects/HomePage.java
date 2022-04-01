package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.BasePage;

public class HomePage extends BasePage{
	
	@FindBy(xpath = "xpath_string")
	private WebElement homeHeader;
	
	@FindBy(xpath = "xpath_string")
	private WebElement homeHeader2;
	
	public WebElement getHomeHeader2() {
		return homeHeader2;
	}

	public WebElement getHomeHeader() {
		return homeHeader;
	}
}
