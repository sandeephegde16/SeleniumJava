package utils;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class DriverFactory {
	protected WebDriver driver;
	protected String browserName;
	protected Properties prop = new Properties();
	
	protected static pageActions.HomePage homePage;
	
	protected DriverFactory() {
		try {
			FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"//src/test//java//globalProperties//globalVariables.properties");
			
			try {
				prop.load(fi);
			} catch(Exception e) {
				e.printStackTrace();
			}
			browserName = prop.getProperty("browser").toLowerCase();
		} catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	protected WebDriver getDriver(String browser) {
		browser.trim();
		if(browser.isEmpty()==false) {
			browserName = browser.toLowerCase();
		}
		try {
			switch(browserName) {
			
			case "firefox":
				if(null==driver) {
					System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//src//geckodriver.exe");
					driver = new FirefoxDriver();
				}
				break;
				
			case "chrome":
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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		return driver;
	}
}
