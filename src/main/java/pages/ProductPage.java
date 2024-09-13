package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BaseTest{
    private WebDriverWait wait;
    public ProductPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, 20);
        this.driver = driver;
    }
    private By quantityInput = By.cssSelector("#exampleInputEmail1");
    private By inputCountry = By.cssSelector("#country");
    private By PurchaseButton = By.cssSelector(".btn.btn-success.btn-lg");
    private By messageSuccess = By.cssSelector(".alert.alert-success.alert-dismissible");
    private By validateCheckoutProducs = By.cssSelector(".nav-link.btn.btn-primary");
    private By buttonCheckout = By.xpath("//button[@class='btn btn-success']");
    private By addButton = By.xpath("(//i[@class='zmdi zmdi-shopping-cart'])[3]");
    private By DescriptoonProduct = By.xpath("(//p[contains(@class,'card-text')])[3]");
    private By priceProduct = By.xpath("(//h5[contains(.,'$24.99')])[3]");
    private By secondSlide = By.cssSelector(".col-lg-9 .carousel-inner .carousel-item.active:nth-of-type(2)");
    private By checkputBtn = By.xpath("//a[contains(@class,'nav-link btn btn-primary')]");

    public void increaseQuantity(int targetQuantity) {
        WebElement quantityElement = wait.until(ExpectedConditions.visibilityOfElementLocated(quantityInput));
        int currentQuantity = 1;
        for (int i = currentQuantity; i < targetQuantity; i++) {
            quantityElement.sendKeys(Keys.ARROW_UP);
        }
        System.out.println("Cantidad ajustada a: " + targetQuantity);
    }


    public void addProductToCart() {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement addProductBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(addButton));
        addProductBtn.click();

        WebElement DescriptionProductPhone = driver.findElement(DescriptoonProduct);
        WebElement priceProductPhone = driver.findElement(priceProduct);

        String textProduct = DescriptionProductPhone.getText();
        String priceProduct = priceProductPhone.getText();
        System.out.printf("Description product: " + textProduct +"and price: " + priceProduct);
    }
    public void screenShotSlide() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(secondSlide));
    }

    public void goToCheckout(){
        WebElement btnCheckout = driver.findElement(checkputBtn);
        btnCheckout.click();
    }

    public void goToMainCheckout(){
        click(buttonCheckout);
    }
    public void sendText(String location) {
        sendKeys(inputCountry, location);
    }

    public void selectPurchase(){
        click(PurchaseButton);
    }
    public String getSuccessMessage() {
        return getText(messageSuccess);
    }
    public int getNumberFromCheckoutText() {
        String text = getText(validateCheckoutProducs);
        return extractNumber(text);
    }
    public int extractNumber(String text) {
        String numberString = text.replaceAll("[^0-9]", "");

        if (!numberString.isEmpty()) {
            try {
                return Integer.parseInt(numberString);
            } catch (NumberFormatException e) {
                System.out.println("Error parsing number from text: " + numberString);
            }
        }
        return 0;
    }
}

