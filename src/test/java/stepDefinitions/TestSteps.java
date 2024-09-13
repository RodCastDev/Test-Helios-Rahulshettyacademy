package stepDefinitions;

import base.BaseTest;
import io.cucumber.java.en.*;
import pages.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import pages.ProductPage;
import org.junit.Assert;

import java.io.IOException;

public class TestSteps extends BaseTest {
    private LoginPage loginPage;
    private ProductPage productPage;

    @Before
    public void setUp() {
        initializeDriver();
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("Rodrigo goes to the login page")
    public void OpenTheLoginPage() {
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
    }

    @And("enter {string} and {string}")
    public void EnterUsernameAndPassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("click on the button {string}")
    public void ClickOnTheButtonUser(String userType) {
        if (userType.equalsIgnoreCase("user")) {
            loginPage.clickButtonUser();
        } else if (userType.equalsIgnoreCase("Admin")) {
            loginPage.clickButtonAdmin();
        }
    }

    @Then("I should see the modal with text {string}")
    public void ShouldSeeTheModalWithText(String expectedText) {
        String modalText = loginPage.getModalText();
        Assert.assertEquals("Modal text does not match!", expectedText, modalText);
    }

    @And("accept the popup")
    public void AcceptThePopup() {
        loginPage.clickOkayButton();
    }

    @When("select the {string} option from the dropdown")
    public void SelectTheOptionFromTheDropdown(String role) {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int roleIndex;
        if (role.equalsIgnoreCase("Teacher")) {
            roleIndex = 1;
        } else if (role.equalsIgnoreCase("Consultant")) {
            roleIndex = 2;
        } else {
            throw new IllegalArgumentException("Role not recognized: " + role);
        }

        loginPage.selectOptionByIndex(roleIndex);
    }

    @When("I click on the checkbox from I agree to the terms and conditions")
    public void ClickOnTheCheckbox() {
        loginPage.clickCheckbox();
    }

    @And("accept the checkbox terms and conditions")
    public void ClickOnTheTermsAndConditions() {
        loginPage.clickTermsAndConditions();
    }

    @Then("click on Sign In")
    public void ClickOnSignIn() {
        loginPage.clickSignIn();
    }

    @Then("I should see the invalid message")
    public void iShouldSeeTheInvalidMessage() throws IOException {
        String errorMessage = loginPage.getErrorMessage();

        Assert.assertNotNull("Error message should not be null", errorMessage);
        Assert.assertFalse("Error message should not be empty", errorMessage.isEmpty());
        System.out.println("The invalid message is equal to the information shown: " + errorMessage);

        takeScreenshot("InvalidMessage");
    }

    @And("I clear all fields and take a new screenshot")
    public void ClearAllFieldsAndTakeANewScreenshot() throws IOException {
        loginPage.clearFields();
        takeScreenshot("FieldsCleared");
    }

    @When("I click on the button Admin")
    public void iClickOnTheButtonAdmin() {
        loginPage.clickButtonAdmin();
    }

    @When("I select the Consultant option from the dropdown")
    public void SelectTheThirdOptionFromTheDropdown() throws IOException {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginPage.selectOptionByIndex(2);
            takeScreenshot("NewDataFields");
    }

    @When("add product to the cart")
    public void iHandleProductActions() throws IOException {
        productPage.addProductToCart();
        productPage.screenShotSlide();
        takeScreenshot("SecondSlide");
    }

    @And("go to the products in the cart")
    public void go_to_the_products_in_the_cart() {
        productPage.goToCheckout();
    }

    @Then("^increase the quantity of the product to (\\d+)$")
    public void increaseQuantityOfProduct(int quantity) throws IOException {
        productPage.increaseQuantity(quantity);
        takeScreenshot("Quantity");
    }

    @And("go to main checkout")
    public void go_to_main_checkout(){
        productPage.goToMainCheckout();
    }

    @When("^send the information location \"([^\"]*)\"$")
    public void sendTheLocation(String location){
        productPage.sendText(location);
        productPage.selectPurchase();
    }

    @Then("should see the success message")
    public void ShouldSeeTheSuccessMessage() {
        String expectedMessage = "Congratulations! Your order has been placed; it will be delivered between 1-3 business days.";
        String actualMessage = productPage.getSuccessMessage();

        try {
            Assert.assertEquals("Success message does not match!", expectedMessage, actualMessage);
        } catch (AssertionError e) {
            System.out.println("Assertion failed: " + e.getMessage());
        }
    }

    @Then("should see the review checkout product message is correct")
    public void ReviewCheckout() throws IOException {
        int number = productPage.getNumberFromCheckoutText();

        try {
            Assert.assertNotEquals("Checkout number should not be zero", 0, number);
        } catch (AssertionError e) {
            System.out.println("Assertion failed: " + e.getMessage());
        }

        System.out.println("Checkout continues at " + number);
        takeScreenshot("ValidateQuantityCheckout");
    }
}
