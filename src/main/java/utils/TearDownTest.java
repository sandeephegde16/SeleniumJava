package utils;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utils.DriverFactory;

public class TearDownTest extends DriverFactory{
	
	@BeforeTest
	@Parameters({"browser"})
	public void setUp(String browser) {
		driver = getDriver(browser);
		switch(prop.getProperty("environment")) {
		case "docker":
			driver.get(prop.getProperty("docker_url"));
			break;
			
		case "test":
			driver.get(prop.getProperty("test_url"));
			break;
		}
	}
	
	@AfterTest
	public void tearDown() {
		try {
			//if test fail, grab screen, log, delete cookies, driver close, driver quit
			//if test pass, log, delete cookies, driver close, driver quit
			driver.close();
			driver.quit();
			driver=null;
		} catch(Exception e) {
			System.out.println("Methods failed: tearDownAndScreenshotOnFailure, Exception: " + e.getMessage());
		}
	} 

}
