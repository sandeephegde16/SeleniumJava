package utils;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class DriverFactory {
	protected WebDriver driver;
	protected String browserName;
	Properties prop = new Properties();
	
	protected static pageActions.HomePage homePage;
	
	protected DriverFactory() {
		try {
			FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"//src/test//java//globalProperties//globalVariables.properties");
			
			try {
				prop.load(fi);
			} catch(Exception e) {
				e.printStackTrace();
			}
			browserName = prop.getProperty("browser");
		} catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	protected WebDriver getDriver() {
		try {
			switch(browserName) {
			
			case "firefox":
				if(null==driver) {
					
				}
				break;
				
			case "Chrome":
				if(null==driver) {
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//chromedriver.exe");
					driver = new ChromeDriver();
				}
				break;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			homePage = PageFactory.initElements(driver, pageActions.HomePage.class);
		}
		
		return driver;
	}
}
