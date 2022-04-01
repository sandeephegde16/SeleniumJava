package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TearDownTest;

public class HomePageTest3 extends TearDownTest{
	
	@Test
	protected void firstTest() throws InterruptedException {
		Assert.assertEquals(homePage.getHomeHeader().getText(), "My Courses & Promo Codes:");
		
	}
	
	@Test
	protected void secondtest() throws InterruptedException {
		homePage.click(homePage.contactUs());
	}
}
