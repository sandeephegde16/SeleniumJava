package utils;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utils.DriverFactory;

public class TearDownTest extends DriverFactory{
	
	
	@BeforeClass
	@Parameters({"browser"})
	public void setUp(String browser) {
		switch(prop.getProperty("environment")) {
		case "docker":
			getDriver(browser).get(prop.getProperty("docker_url"));
			break;
			
		case "test":
			getDriver(browser).get(prop.getProperty("test_url"));
			break;
		}
	}
	
	@AfterClass
	public void tearDown() {
		try {
			//if test fail, grab screen, log, delete cookies, driver close, driver quit
			//if test pass, log, delete cookies, driver close, driver quit
			driver.get().close();
			driver.get().quit();
			driver.remove();
		} catch(Exception e) {
			System.out.println("Methods failed: tearDownAndScreenshotOnFailure, Exception: " + e.getMessage());
		}
	} 

}
