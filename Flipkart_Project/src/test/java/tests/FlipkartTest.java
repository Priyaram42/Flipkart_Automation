package tests;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CheckPlacedOrderPage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.PlaceOrderPage;
import pages.ProductDetails;
import pages.SearchProduct;
import utils.Base;

public class FlipkartTest extends Base {

	LoginPage loginPage;
	@Test
	public void login() {
		loginPage = new LoginPage(driver);
		boolean actResult = loginPage.validateLogin("9608036638");
		assertTrue(actResult);
	}
	
	@Test
	public void placeorderpage(){
		
		// Search for a product
		SearchProduct searchProduct = new SearchProduct(driver);
		searchProduct.ValidateSearch("Laptop");
		
		
		// Handle window switching
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		ProductDetails productDetails = new ProductDetails(driver);
		
		// Validate product title
		productDetails.clickCompareCheckbox();
		
		//productDetails.clickFlipkartAssured();
		
		
		// Add product to cart and validate success
		Assert.assertTrue(productDetails.clickbuynow(), "Failed to add product to cart.");
		
		
		PlaceOrderPage placeorderpage = new PlaceOrderPage(driver);
		placeorderpage.OrderSummary();
		
		CheckPlacedOrderPage  checkplacedorder = new CheckPlacedOrderPage(driver);
		checkplacedorder.cPlaceOrder();
		
	}
	
	@Test
	public void searchproduct() {
		SearchProduct searchProduct = new SearchProduct(driver);
		searchProduct.ValidateSearch("Laptop");
		}
	
	
	@Test
	public void productdetails() {
		ProductDetails productdetails = new ProductDetails(driver);
		productdetails.clickCompareCheckbox();
		productdetails.clickFlipkartAssured();
		productdetails.clickbuynow();
		assertTrue(productdetails.clickbuynow(), "Failed to add product to cart.");
	}
	
	
	@Test
	public void checkplacedorder() {
		CheckPlacedOrderPage  checkplacedorder = new CheckPlacedOrderPage(driver);
		checkplacedorder.cPlaceOrder();
	}

	@BeforeClass
	public void setUp() {
		launchBrowser();
	}

	@AfterClass
	public void tearDown() 
	{
		LogoutPage logout = new LogoutPage(driver);
		logout.logout();
		driver.close();
	}
}