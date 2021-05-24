package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utility.ConfigFileReader;


public class StepDef {
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
	@Given("^I click on Donate now button$")
	public void i_click_on_Donate_now_button() throws Throwable {
		homepage = new HomePage(driver);
		homepage.clickDonateNow();
	}
	@And("^I enter amount as (.+)$")
	public void i_enter_amount_as(String amountMoney) throws Throwable {

		homepage = new HomePage(driver);
		homepage.enterAmount(amountMoney);
	}
	@And("^I enter name as (.+)$")
	public void i_enter_name_as(String name) throws Throwable {

		homepage = new HomePage(driver);
		homepage.enterName(name);
	}
	@And("^I enter Email as (.+)$")
	public void i_enter_Email_as(String emailID) throws Throwable {

		homepage = new HomePage(driver);
		homepage.enterEmailId(emailID);
	}
	@And("^I enter phone number as (.+)$")
	public void i_enter_phone_number_as(String contactNumber) throws Throwable {

		homepage = new HomePage(driver);
		homepage.enterPhoneNumber(contactNumber);
	}
	@And("^I enter Billing city as (.+)$")
	public void i_enter_Billing_city_as(String cityName) throws Throwable {

		homepage = new HomePage(driver);
		homepage.enterCityName(cityName);
	}
	@Given("^I click on Donate now$")
	public void i_click_on_Donate_now() throws Throwable {
		homepage = new HomePage(driver);
		homepage.clickDonateNowFinal();
	}
	@When("^I enter card details as (.+) and (.+) and (.+)$")
	public void i_enter_card_details_as_and_and(String cardDetails, String monthYear, String cvv) throws Throwable {
		homepage = new HomePage(driver);
		homepage.enterCardDetails(cardDetails,monthYear,cvv); 
	}

	@Then("^I click on contribute$")
	public void i_click_on_contribute() throws Throwable {
		homepage = new HomePage(driver);
		homepage.clickContributeButton();
	}
	@And("^I verify the confirm message$")
	public void i_verify_the_confirm_message() throws Throwable {
		homepage = new HomePage(driver);
		homepage.verifyConfirmMessage();
	}
	@And("^I verify the minimum amount error message$")
	public void i_verify_the_minimum_amount_error_message() throws Throwable {
		homepage = new HomePage(driver);
		homepage.validateMinAmountErrormsg();
	}
	@After
    public void tearDown(){
		driver.close();
		driver.quit();
    }
}