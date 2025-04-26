package pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.Locators;
import utils.Base;

public class ProductDetails {

    private WebDriver driver;
    private static final Duration TIMEOUT = Duration.ofSeconds(20);

    public ProductDetails(WebDriver driver) {
        this.driver = driver;
    }

    public String clickCompareCheckbox() {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        WebElement productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.compare));
        return productTitle.getText();
    }

    public String clickFlipkartAssured() {
    	WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        WebElement productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.assured));
        return productTitle.getText();
    }

    public boolean clickbuynow() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(Locators.buynow));
            addToCartButton.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean clickProductAndSwitchToNewWindow(By productLocator) {
        // Click on the product link
        driver.findElement(productLocator).click();

        // Get the current window handle
        String currentWindow = driver.getWindowHandle();

        // Wait for a new window to open
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        // Switch to the new window
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        // Wait for the new window to load completely
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
        
        boolean actResult = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.btncontinue));
		} catch (TimeoutException te) {
			Base.captureScreenShot("Verify_Failure");
			actResult = false;
		}
		return actResult;
    }
}

