package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.security.Credentials;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import utility.BasePage;
import utility.ConfigFileReader;
import utility.Constants;



public class LoginPage extends BasePage {

	ConfigFileReader config;
	Constants constant = new Constants();
	public static final String stageUrl = "staging.igstg.com/fundraiser/help-testdocumentchecklist";
	public static final String ID_UsernamePassword ="auth-local-btn";
	public static final String ID_Username ="username";
	public static final String ID_Password ="password";
	public static final String submit_Button = "submit";
	public static final String ID_DonateNow = "cmp-nfr-top-side-donate";
	public LoginPage (WebDriver driver) {
		super(driver);
	}
	
	public void enterURL() {
		config = new ConfigFileReader();
		driver.get(config.getUrl());			
	}
	public void clickUsernamePassbtn() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(ID_UsernamePassword)));
		driver.findElement(By.id(ID_UsernamePassword)).click();
	}
	public void enterCredentials() throws InterruptedException {
		driver.findElement(By.id(ID_Username)).clear();
		driver.findElement(By.id(ID_Username)).sendKeys(constant.userName);
		driver.findElement(By.id(ID_Password)).clear();
		driver.findElement(By.id(ID_Password)).sendKeys(constant.password);
		driver.findElement(By.id(submit_Button)).submit();
		Thread.sleep(2000);
		String URL = "https://" + constant.stageUserName + ":" + constant.stagePassword + "@" + stageUrl;
		driver.get(URL);
	}
}
