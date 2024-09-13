package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseTest {
    private WebDriverWait wait;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By buttonLocatorUser = By.xpath("(//span[@class='checkmark'])[2]");
    private By buttonLocatorAdmin = By.xpath("(//span[contains(@class,'checkmark')])[1]");
    private By modalText = By.xpath("//div[@class='modal-body']");
    private By okayButton = By.xpath("//button[@type='button'][contains(.,'Okay')]");
    private By selectElementLocator = By.xpath("//select[@class='form-control']");
    private By checkboxLocatorTerms = By.id("terms");
    private By termsAndConditionsLink = By.xpath("//a[@href='#'][contains(.,'terms and conditions')]");
    private By signInButton = By.id("signInBtn");
    private By errorMessage = By.xpath("//*[@id='login-form']/div[1]");


    // Page Methods
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickButtonUser() {
        WebElement button = driver.findElement(buttonLocatorUser);
        button.click();

    }public void clickButtonAdmin() {
        WebElement button = driver.findElement(buttonLocatorAdmin);
        button.click();
    }

    public String getModalText() {
        WebElement modalTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(modalText));
        String text = modalTextElement.getText();
        System.out.println("Texto del modal: " + text);
        return text;
    }


    public void clickOkayButton() {
        WebElement okayBtnElement = wait.until(ExpectedConditions.elementToBeClickable(okayButton));
        okayBtnElement.click();
        okayBtnElement.click();
        System.out.println("Clicked on 'Okay' button.");
    }

    public void selectOptionByIndex(int index) {
        WebElement selectElement = driver.findElement(selectElementLocator);
        Select select = new Select(selectElement);
        select.selectByIndex(index);
    }

    public void clickCheckbox() {
        WebElement checkbox = driver.findElement(checkboxLocatorTerms);
        checkbox.click();
    }

    public void clickTermsAndConditions() {
        WebElement link = driver.findElement(termsAndConditionsLink);
        link.click();
    }
    public void clickSignIn() {
        click(signInButton);
    }

    public String getErrorMessage() {
        WebElement modalErroText = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        String textModal = modalErroText.getText();
        return textModal;
    }

    public void clearFields() {
        WebElement username = driver.findElement(usernameField);
        WebElement password = driver.findElement(passwordField);

        username.clear();
        password.clear();
    }
}