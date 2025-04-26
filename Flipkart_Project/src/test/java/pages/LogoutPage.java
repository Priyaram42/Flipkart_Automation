package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import objectRepository.Locators;

public class LogoutPage {
	private WebDriver driver;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void logout() {
		Actions as=new Actions(driver);
		as.moveToElement(driver.findElement(Locators.acntOut)).perform();
		driver.findElement(Locators.logout).click();
			}

}
