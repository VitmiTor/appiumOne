package page;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utilities.Logs;

public class LoginPage extends BasePage {

    private final By loginInput = new AppiumBy.ByAccessibilityId("test-Username");

    private final By passwordInput = new AppiumBy.ByAccessibilityId("test-Password");
    private final By loginButton = new AppiumBy.ByAccessibilityId("test-LOGIN");
    private final By errorBox = new AppiumBy.ByAccessibilityId("test-Error message");
    private final String lockedOutLabel = "description(\"test-locked_out_user\")";


    private By getErrorMessageBy(String error) {
        final var uiautomator2Locator = String.format("text(\"%s\")", error);
        return new AppiumBy.ByAndroidUIAutomator(uiautomator2Locator);
    }

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageToLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(driver.findElement(loginInput).isDisplayed());
    }

    public void fillingform(String username, String password) {
        Logs.info("Writing username");
        driver.findElement(loginInput).sendKeys(username);
        Logs.info("Writing password");
        driver.findElement(passwordInput).sendKeys(password);
        clickOnLogin();
    }

    public void verifyErrorMesage(String message) {
        Logs.info("Waiting for error messages");
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorBox));
        Logs.info("Verifying errorMessage");
        Logs.debug(message);
        Assert.assertTrue(driver.findElement(errorBox).isDisplayed());

        Assert.assertTrue(driver.findElement(getErrorMessageBy(message)).isDisplayed());
    }

    public void scrollLockedOutUserLogin() {
        Logs.info("Scroll and tap on lcoked user");
        gestures.verticalScrollInto(lockedOutLabel).click();
    }

    public void clickOnLogin() {
        Logs.info("Clicking on Login Button");
        driver.findElement(loginButton).click();
    }

}
