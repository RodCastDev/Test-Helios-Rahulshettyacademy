# language: en
# author: rodrigocastp05@gmail.com

Feature: As a QA automator I want to test the security
  of the login entered with incorrect data

  Scenario Outline: Login and validate modal and error messages
    Given Rodrigo goes to the login page
    And enter "<username>" and "<password>"
    And click on the button "<userType>"
    Then I should see the modal with text "You will be limited to only fewer functionalities of the app. Proceed?"
    And accept the popup
    When select the "<role>" option from the dropdown
    And I click on the checkbox from I agree to the terms and conditions
    And accept the checkbox terms and conditions
    And click on Sign In
    Then I should see the invalid message
    And I clear all fields and take a new screenshot
    When enter "<usernameOk>" and "<passwordOk>"
    And I click on the button Admin
    When select the "<roleOk>" option from the dropdown
    And I select the Consultant option from the dropdown
    Then click on Sign In

    Examples:
      | username           | password     | userType | role    | usernameOk         | passwordOk | roleOk     |
      | rahulshettyacademy | UniqueTest02 | user     | Teacher | rahulshettyacademy | learning   | Consultant |

