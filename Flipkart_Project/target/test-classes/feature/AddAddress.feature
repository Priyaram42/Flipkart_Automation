Feature: Add Address in Profile Section

  Scenario: Add an address in Profile section is successful
    Given the user on Flipkart home page
    When the user clicks on login button and enter "<MobileNumber>" and click Request OTP button
    And the user navigates to the Profile section and I click on "Add Address" 
    And the user enters "<FullName>", "<Zipcode>", "<Address>", "<City>" and "<State>", select home option and click Save button 
    Then the user should see a success message "Address added successfully"
    
    Examples: 
     |MobileNumber | FullName     | Zipcode    | Address     | City     | State      | 
     |7795833409   | Saipriya Ram | 560077     | ABC street  | Bangalore| Karnataka  | 
      
              
  Scenario: Add address fails with empty fields
    Given the user on Flipkart home page
    When the user clicks on login button and enter "<MobileNumber>" and click Request OTP button
    And the user navigates to the Profile section and clicks on "Add Address"
    And the user enters "<FullName>", "<Zipcode>", "<Address>", "<City>" and "<State>", select home option and click Save button 
    Then the user should see an error message "<ErrorMessage>"
    
    Examples: 
      |MobileNumber| Full Name    | Zipcode   | Address  | City       | State      | ErrorMessage |
      |7795833409  | Saipriya Ram | 560063    |          | Bangalore  |            | Please fill in all required fields|
    
