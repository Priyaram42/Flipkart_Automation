package pages;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.Locators;
import utils.Base;

public class PlaceOrderPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public PlaceOrderPage(WebDriver driver) 
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.driver=driver;
	}
	
  public boolean OrderSummary() {
	  
	  driver.findElement(Locators.btncontinue).click();
	  Base.sleep(Base.WAITTIME);
	  driver.findElement(Locators.btnac).click();
	  Base.sleep(Base.WAITTIME);
	  driver.findElement(Locators.card).click();
	  driver.findElement(Locators.cardno).sendKeys("5261023787929574");
	  Select month = new Select(driver.findElement(Locators.month));
	  month.selectByValue("05");
	  
	  Select year = new Select(driver.findElement(Locators.year));
	  year.selectByValue("26");
	  
	  driver.findElement(Locators.cvv).sendKeys("108");
	  
	  Base.sleep(Base.WAITTIME);
	  
	  driver.findElement(Locators.zip).sendKeys("825301");
	  
	  Select country = new Select(driver.findElement(Locators.country));
	  country.selectByValue("India");
	  
	  driver.findElement(Locators.city).sendKeys("Hazaribag");
	  driver.findElement(Locators.state).sendKeys("Jharkhand");
	  driver.findElement(Locators.address).sendKeys("Hazaribagh");
	  driver.findElement(Locators.payment).click();
	  
	  Base.sleep(Base.WAITTIME);
	  driver.findElement(Locators.back).click();
	  
	  Base.sleep(Base.WAITTIME);	  
	  driver.findElement(Locators.cancel).click();
	  
	  Base.sleep(Base.WAITTIME);	  
	  driver.findElement(Locators.title).click();
	  
	  boolean actResult = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.payment));
		} catch (TimeoutException te) {
			Base.captureScreenShot("Verify_Failure");
			actResult = false;
		}
		return actResult;
	}
}

