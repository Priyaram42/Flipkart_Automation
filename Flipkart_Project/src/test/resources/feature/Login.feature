 Feature: Login
 
Scenario: Successful login with valid credentials
    Given the user on Flipkart home page
    When the user clicks on login button and enter "<MobileNumber>" and click Request OTP button
    Then the user verify Flipkart homepage is displayed
    
    Examples: 
    |MobileNumber|
    |7795833409  |

  Scenario: Login with invalid credentials
    Given the user on Flipkart home page
    When the user clicks on login button and enter invalid "<MobileNumber>"  
    Then the user should see an "<Error message>" 
    
    Examples:
    |MobileNumber|ErrorMessage         |
    |1234567890  |Invalid Mobile Number|
    
    
