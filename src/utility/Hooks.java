package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	WebDriver driver;
	ConfigFileReader config;
	
	//@Before
    public void setUp(){
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\ABHILASH\\Downloads\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		config = new ConfigFileReader();
		String Browser = config.getBrowserName();
		if(Browser=="Chrome") {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABHILASH\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
    }	
	
	@After
    public void tearDown(){
		System.out.println("end");
    }
	
}
