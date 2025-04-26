Feature: Filtering Product

  Scenario: Filter products by category
    Given the user is on Flipkart home page
    When the user click on login button and enter "<MobileNumber>" and click Request OTP button
    When the user search the "<Product>"
    And the user click on category filter as "<Processor>"
    Then the user verifies only products from the selected category should be displayed
    
    Examples:
    |MobileNumber|Product|Processor|
    |7795833409  |Laptop |Core i5  |
    
    
  Scenario: Filter products by price
    Given the user is on Flipkart home page
    When the user click on login button and enter "<MobileNumber>" and click Request OTP button
    When the user search the "<Product>"
    And the user select a price range filter as "<Min>" and "<Max>"
    Then the user verifies only products within the selected price range should be displayed

		Examples:
		|MobileNumber|Product|Min  |Max  |
		|7795833409  |Laptop |20000|75000|
		
  Scenario: Filter products by rating
    Given the user on Flipkart home page
    When the user click on login button and enter "<MobileNumber>" and click Request OTP button
    When the user search the "<Product>"
    And the user will apply a rating filter as "<CustomerRating>"
    Then the user verifies only products with the selected rating or higher should be displayed
		
		Examples:
		|MobileNumber| Product | CustomerRatings |
		|7795833409  | Laptop  | 4★ & above		   |