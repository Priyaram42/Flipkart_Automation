package pages;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.Locators;
import utils.Base;

public class SearchProduct extends Base{

	private WebDriver driver;
	public SearchProduct(WebDriver driver) {
		this.driver = driver;
	}
	
	public void ValidateSearch(String product)  {
		
		driver.findElement(Locators.searchbar).sendKeys("Laptop");
		driver.findElement(Locators.btnsearch).submit();
		
		Base.sleep(Base.WAITTIME);
		
		Select min = new Select(driver.findElement(Locators.min_price));
		min.selectByValue("20000");
		
		Select max = new Select(driver.findElement(Locators.max_price));
		max.selectByValue("Max");
				
		driver.findElement(Locators.rating).click(); //Rating

		Base.sleep(Base.WAITTIME);
		
		driver.findElement(Locators.proc).click(); //Processor
		
		Base.sleep(Base.WAITTIME);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.findElement(Locators.product).click();
		
	}
}