package pages;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.Locators;
import utils.Base;

public class LoginPage {
	
	private WebDriverWait wait;
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public boolean validateLogin(String number) {

		driver.findElement(Locators.btnlog).click();;
		driver.findElement(Locators.btno).sendKeys(number);
		driver.findElement(Locators.btnotp).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.searchbar));
	
	boolean actResult = true;

	try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.acnt));
	} catch (TimeoutException te) {
		Base.captureScreenShot("Login_Failure");
		actResult = false;
	}
	return actResult;
	}
}
