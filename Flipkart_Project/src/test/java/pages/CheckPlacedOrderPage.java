package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.Locators;

public class CheckPlacedOrderPage {
	private WebDriver driver;
	public CheckPlacedOrderPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void cPlaceOrder() {
		
		Actions as=new Actions(driver);
		as.moveToElement(driver.findElement(Locators.acnt)).perform();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.order));

		driver.findElement(Locators.acnt).click();
		driver.findElement(Locators.order).click();
			
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(Locators.history));

		driver.findElement(Locators.history).click();
	}

}
