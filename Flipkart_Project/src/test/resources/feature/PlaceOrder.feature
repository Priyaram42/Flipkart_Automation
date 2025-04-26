Feature: Place Order

  Scenario: Place an order Successfully
    Given the user on Flipkart home page
    When the user clicks on login button and enter "<MobileNumber>" and click Request OTP button
    And the user search the "<Product>"
    And the user selects the "<NthProduct>"
    And the user clicks AddToCart button
    And the user selects Address
    And the user provides payment details
    And the user clicks confirm order
    Then the user clicks logout button
    
    Examples: 
    |MobileNumber|Product |NthProduct|
    |7795833409  |Laptop  |5         |
    

  Scenario: Placing the order is Failed
    Given the user on Flipkart home page
    When the user click on login button and enter "<MobileNumber>" and click Request OTP button
    And the user search the "<Product>"
    And the user select the "<NthProduct>"
    And the user click AddToCart button
    And the user select Address
    And the user provide invaild payment details as "<Cardnumber>" and "<CVV>"
    Then the user sees an "<ErrorMessage>" 
    
    
    Examples: 
    |MobileNumber |Product|NthProduct|Cardnumber |CVV |Error message               |
    |7795833409   |Laptop |5         |123456789  |754 |Please fill in Valid Details|
    
    
    