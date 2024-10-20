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
    And the user should see "Didi Sport Watch"
  When the user mouseover "Didi Sport Watch" item
  Then the user should see "Add to Cart" button for "Didi Sport Watch"
  Then the user click on "Add to Cart" button for "Didi Sport Watch"
  Then the user click on cart icon
  And the user should see the "Proceed to Checkout" Button
  And the user should see the "Edit item" icon
  And the user should see the "Remove item" icon
  And the user clicks on the "Edit item" icon
    And the user should see the "Update Cart" Button
    And the user should see the "Qty" Textbox
    And user enters "2" in quantity textbox
    And the user clicks on the "Update Cart" button
    And user should see "updated in your shopping cart." message
    And the user should see order summery in checkout cart
    And the user should see the cart total table in checkout cart
    And the user should "Subtotal" as "$184.00" in table
   And the user should "Order Total" as "$184.00" in table
    And the user should see "Didi Sport Watch"
    And the user should see the Proceed to Checkout Button
    And the user clicks on the Proceed to Checkout button
  And the user should see checkout page
  And the user should see Order Summary
  And the user should see the ShippingAddress
  And the user should fill the Address details
      | field           | value             |
      | firstname       | Suresh             |
      | lastname        | Bandi          |
      | company         | Test          |
      | street[0]       | 123 ABC                   |
      | street[1]      |RoadNumber1                   |
      | street[2]       |Villas                    |
      |Country            | India                |
      |State               | Telangana            |
      |city                |Hyderabad             |
      |postcode          |502032              |
      | telephone   | 9995550030         |
    And the user clicks on the "Next" button
    And the use should see paymentMethod
    And the user should see Order Summary
    And the user should "Cart Subtotal" as "$184.00" in table
    And the user should "Shipping" as "$10.00" in table
    And the user should "Order Total" as "$194.00" in table
    And the user should see "2" items in cart
    And the user should see the "Place Order" Button
    And the user clicks on the "Place Order" button
    Then the user see "Thank you for your purchase!"
    And the user see the orderid

