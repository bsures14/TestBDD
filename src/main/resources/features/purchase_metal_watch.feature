@PurchaseMetalWatch
Feature: Successfully Purchasing a Metal Watch

  As a registered user of the Magento store
  I want to purchase a metal watch
  So that I can add a stylish accessory to my collection

  Scenario: Successfully purchasing a metal watch
    Given the user opens the Magento store homepage
    And the user should see the " Sign In " link
    And the user clicks on the " Sign In " link
    When the user navigates to the login page
    And the user should see the "Email" textbox
    And the user should see the "Password" textbox
    And the user should see the "SignInButton" button
    When the user enters valid login credentials
      | Username                   | Password     |
      | sureshbanditest@gmail.com  | Password@123 |
    And the user clicks the "signIn" button
    Then the user should be redirected to the dashboard
    And the user should see a  "Welcome, Suresh Bandi!" message
    And the user should see the "Gear" link in dashboard
    And  the user clicks on the "Gear" link in dashboard
    When the user click on "Watches" section
  Then the user should see the "Watches" header
  When the user clicks on "Material" filter
  Then the user clicks on the "Metal " link on filer
  When the user mouseover "Didi Sport Watch" item
  Then the user should see "Add to Cart" button for "Didi Sport Watch"
  Then the user click on "Add to Cart" button for "Didi Sport Watch"
  Then the user click on cart icon


#
#    When the user selects a metal watch from the listings
#    And the user should see the watch details page with the correct product information
#    And the user clicks the "Add to Cart" button
#    Then a confirmation message "You added [Watch Name] to your shopping cart." should be displayed
#
#    When the user proceeds to the checkout page
#    Then the user should see the cart summary with the correct item details
#    And the user clicks the "Checkout" button
#    And the user fills in the shipping information
#      | Field           | Value                 |
#      | Full Name       | John Doe             |
#      | Address         | 123 Main St          |
#      | City            | Springfield          |
#      | State           | IL                   |
#      | Zip Code        | 62701                |
#      | Phone Number    | 555-123-4567         |
#    And the user clicks the "Continue" button
#    And the user selects the payment method
#    And the user enters payment details
#    And the user clicks the "Place Order" button
#    Then the user should see a confirmation message "Thank you for your purchase!"
#    And the order ID should be displayed for future reference
