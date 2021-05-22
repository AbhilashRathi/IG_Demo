package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import utility.BasePage;
import utility.ConfigFileReader;

public class HomePage extends BasePage{

	public static final String actualMessage = "test, pat your back!";
	public static final String ID_DonateNow = "cmp-nfr-top-side-donate";
	public static final String ID_DonationAmount = "story_popup_donation_amount";
	public static final String ID_FullName = "full_name";
	public static final String ID_EmailId = "email_receipt";
	public static final String ID_PhoneNumber = "mobile";
	public static final String ID_City = "city_text";
	public static final String ID_DonateNowFinal = "story-popup-donate-button";
	public static final String ID_CardNumber = "cardNumber";
	public static final String ID_ExpiryDate = "expiryDate";
	public static final String ID_CvvNumber = "cvvNumber";
	public static final String ID_ContributeBtn = "donate-card-contribute";
	public static final String Class_ThankYouText = "thankyou-banner__content-main";

	public HomePage (WebDriver driver) {
		super(driver);
	}
	
	public void clickDonateNow() throws InterruptedException {
		Thread.sleep(1500);
		WebElement element = driver.findElement(By.id(ID_DonateNow));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();",element);
	}
	
	public void enterAmount(String amountMoney) {
		driver.findElement(By.id(ID_DonationAmount)).clear();
		driver.findElement(By.id(ID_DonationAmount)).sendKeys(amountMoney);
	}
	
	public void enterName(String Name) {
		driver.findElement(By.id(ID_FullName)).clear();
		driver.findElement(By.id(ID_FullName)).sendKeys(Name);
	}
	public void enterEmailId(String emailId) {
		driver.findElement(By.id(ID_EmailId)).clear();
		driver.findElement(By.id(ID_EmailId)).sendKeys(emailId);
	}
	public void enterPhoneNumber(String contactNumber) {
		driver.findElement(By.id(ID_PhoneNumber)).clear();
		driver.findElement(By.id(ID_PhoneNumber)).sendKeys(contactNumber);
	}
	public void enterCityName(String cityName) {
		driver.findElement(By.id(ID_City)).clear();
		driver.findElement(By.id(ID_City)).sendKeys(cityName);
	}
	public void clickDonateNowFinal() {
		driver.findElement(By.id(ID_DonateNowFinal)).click();
	}
   public void enterCardDetails(String cardNumber, String monthYear, String cvv) {
	   driver.findElement(By.id(ID_CardNumber)).sendKeys(cardNumber);
	   driver.findElement(By.id(ID_ExpiryDate)).sendKeys(monthYear);
	   driver.findElement(By.id(ID_CvvNumber)).sendKeys(cvv);
   }
   public void clickContributeButton() {
	   driver.findElement(By.id(ID_ContributeBtn)).click(); 
   }
   public void verifyConfirmMessage() {
	   String expectedMsg = driver.findElement(By.className(Class_ThankYouText)).getText();
	   Assert.assertEquals("Validation failed",expectedMsg, actualMessage);
   }
    }
