# language: en
# author: rodrigocastp05@gmail.com

Feature: As a QA automator I want to test the ability for
  a customer to add a product increasing its successful quantity

  Scenario Outline: Purchase of product on the rahulshettyacademy page
    Given Rodrigo goes to the login page
    And enter "<username>" and "<password>"
    And click on the button "<userType>"
    When select the "<role>" option from the dropdown
    And accept the checkbox terms and conditions
    Then click on Sign In
    When add product to the cart
    And go to the products in the cart
    Then increase the quantity of the product to <quantity>
    And go to main checkout
    When send the information location "<pais>"
    Then should see the success message
    Then should see the review checkout product message is correct

    Examples:
      | username           | password | userType | role       | quantity | pais     |
      | rahulshettyacademy | learning | Admin    | Consultant | 3        | Colombia |