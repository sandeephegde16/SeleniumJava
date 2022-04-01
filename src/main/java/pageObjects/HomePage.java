package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.BasePage;

public class HomePage extends BasePage{
	
	@FindBy(xpath = "//div[@id='udemy-promo-thumbnail']/h1")
	private WebElement homeHeader;
	
	@FindBy(xpath= "//h1[contains(text(), 'CONTACT')]")
	private WebElement contactUs;

	public WebElement getHomeHeader() {
		return homeHeader;
	}	
	
	public WebElement contactUs() {
		return contactUs;
	}
}
