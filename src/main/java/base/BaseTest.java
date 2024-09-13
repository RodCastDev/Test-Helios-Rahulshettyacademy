package base;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public void initializeDriver() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\rodri\\ChallengeHelios\\ChallengeHeliosworldwide\\src\\main\\resources\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
    }
    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void sendKeys(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }
    protected String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    protected void takeScreenshot(String filename) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String folderPath = "C:/Users/rodri/ChallengeHelios/ChallengeHeliosworldwide/screenshots/";
        Files.createDirectories(Paths.get(folderPath));
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        File destinationFile = new File(folderPath + filename + "_" + timestamp + ".png");

        Files.copy(screenshot.toPath(), destinationFile.toPath());
    }

}
