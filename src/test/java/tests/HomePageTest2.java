package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TearDownTest;

public class HomePageTest2 extends TearDownTest{
	
	@Test
	protected void firstTest() throws InterruptedException {
		Assert.assertEquals(homePage.getHomeHeader().getText(), "Fail Test");
		
	}
	
	@Test
	protected void secondtest() throws InterruptedException {
		homePage.click(homePage.contactUs());
	}
}
