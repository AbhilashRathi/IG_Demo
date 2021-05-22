package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utility.ConfigFileReader;


public class LoginStepDef {
	WebDriver driver;
	WebDriverWait wait = null;
	HomePage homepage;
	LoginPage loginpage;
	
	ConfigFileReader config;
	
	@Before
    public void setUp(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABHILASH\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//driver.manage().deleteAllCookies();
    }	
	
@Given("^I am on a login page$")
public void i_am_on_a_login_page() throws Throwable {
    loginpage = new LoginPage(driver);
	loginpage.enterURL();
}
@When("^I click on username password button$")
public void i_click_on_username_password_button() throws Throwable {
	loginpage = new LoginPage(driver);
	loginpage.clickUsernamePassbtn();
}
@When("^I login to Donate now page$")
public void i_login_to_Donate_now_page() throws Throwable {
	loginpage = new LoginPage(driver);
	loginpage.enterCredentials();
}

}