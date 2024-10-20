@loginPageErrorMessages @All
Feature: Login page error message validations

  Background: Launch login page
    Given the user opens the Magento store homepage
    And the user should see the " Sign In " link
    When the user clicks on the " Sign In " link
    Then the user navigates to the login page
    And the user should see the "Email" textbox
    And the user should see the "Password" textbox
    And the user should see the "SignInButton" button

  Scenario: login with empty username and password
    When the user clicks the "signIn" button
    Then the user should see error message for "email" as "This is a required field."
    And the user should see error message for "password" as "This is a required field."

  Scenario: login with Invalid email
    When the user enters "email" as "suresh"
    When the user enters "password" as "123"
    And the user clicks the "signIn" button
    Then the user should see error message for "email" as "Please enter a valid email address (Ex: johndoe@domain.com)."

  Scenario: login with empty email
    And the user clears the "email" field
    When the user enters "password" as "suresh"
    And the user clicks the "signIn" button
    And the user should see error message for "email" as "This is a required field."

  Scenario: login with empty password
    And the user clears the "password" field
    When the user enters "email" as "sureshbanditest@gmail.com"
    And the user clicks the "signIn" button
    And the user should see error message for "password" as "This is a required field."

  Scenario: login with Invalid Credentials
    And the user clears the "email" field
    And the user clears the "password" field
    When the user enters "email" as "sureshbanditest@gmail.com"
    When the user enters "password" as "123"
    And the user clicks the "signIn" button
    Then the user should see invalid login error message as "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later."
