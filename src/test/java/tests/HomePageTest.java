package tests;

import org.testng.annotations.Test;

import utils.DriverFactory;

public class HomePageTest extends DriverFactory{
	
	@Test
	protected void firstTest() {
		homePage.getHomeHeader();
	}
	
	protected void secondtest() {
		homePage.getHomeHeader2();
	}
}
