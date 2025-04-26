Feature: Check Placed Order

  Scenario: View Order Status
    Given the user on Flipkart home page
    When the user clicks on login button and enter "<MobileNumber>" and click Request OTP button
    Then the user navigates to My Account then click order submenu
    Then the user verify all the previous order placed are display properly
    
    Examples: 
    |MobileNumber|
    |7795833409  |
    

  Scenario: Attempt to Cancel a Shipped Order
    Given the user on Flipkart home page
    When the user clicks on login button and enter "<MobileNumber>" and click Request OTP button 
    Then the user navigates to My Account then click order submenu
    And the user attempts to cancel the shipped order
    Then the user see the system should display a message stating that cancellation is not allowed for shipped orders
    
    Examples: 
    |MobileNumber|
    |7795833409  |
    

  