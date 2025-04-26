package objectRepository;

import org.openqa.selenium.By;

public class Locators {

	// Login Page
	public static By btnlog = By.xpath("//span[text()='Login']"); 
	public static By btno = By.xpath("//input[@class='r4vIwl BV+Dqf']");
	public static By btnotp = By.xpath("//button[text()='Request OTP']");

	// Search
	public static By searchbar = By.xpath("//input[@class='Pke_EE']"); // search bar
	public static By btnsearch = By.xpath("//button[@class='_2iLD__']"); // search button


	// Filter
	public static By min_price = By.xpath("(//select[@class='Gn+jFg'])[1]"); // Minimum Price
	public static By max_price = By.xpath("(//select[@class='Gn+jFg'])[2]"); // Maximum Price element
	public static By rating = By.xpath("//div[@title='4★ & above']"); // Rating element
	public static By proc = By.xpath("//div[text()='Core i5']"); //Processor element


	// ProductDeatilsPage
	
	public static By product = By.xpath("(//div[@class='KzDlHZ'])[1]"); //Product
	public static By compare = By.xpath("//label[@class='tJjCVx']"); //Click on Compare Checkbox
	public static By assured = By.cssSelector(".LctmNn"); //Click on Flipkart Assured
	
	
	//Buy Now
	public static By buynow = By.xpath("//button[text()='Buy Now']");// Buy Now Button
	
	//PlaceOrder
	public static By btncontinue = By.xpath("//button[@class='QqFHMw VuSC8m _7Pd1Fp']"); //address continue
	public static By btnac = By.xpath("//button[text()='Accept & Continue']"); //popup
	public static By card = By.xpath("//span[text()='Credit / Debit / ATM Card']"); //card option
	public static By cardno = By.xpath("//input[@name='cardNumber']"); //card number
	
	public static By month = By.xpath("//select[@name='month']"); // card month
	public static By year = By.xpath("//select[@name='year']"); // card year
	public static By cvv = By.xpath("//input[@name='cvv']"); // card cvv4
	public static By zip = By.xpath("//input[@name='billing_pincode']"); //pincode
	public static By country = By.xpath("//select[@name='billing_country']"); //select country
	public static By city = By.xpath("//input[@name='billing_city']"); //city
	public static By state = By.xpath("//input[@name='billing_state']"); //state
	public static By address = By.xpath("//textarea[@name='billing_address']"); //address
	
	public static By payment = By.xpath("//button[@class='QqFHMw JO5Wdq TVgwvR _7Pd1Fp']"); //payment
	
	public static By back = By.xpath("//span[@id='back']");
	public static By cancel = By.xpath("//button[@id='closeYes']");
	
	public static By title = By.xpath("//div[@class='F9+fd2']");
	
	//CheckPlacedOrder
	public static By acnt=By.xpath("//span[text()='Prerna']");
	public static By order=By.xpath("(//a[@class='yx2hEq'])[4]");
	public static By history=By.xpath("(//div[@class='_4teGKY'])[2]");

	public static By acntOut=By.xpath("//span[text()='Prerna']");
	public static By logout=By.xpath("//li[text()='Logout']");

}
