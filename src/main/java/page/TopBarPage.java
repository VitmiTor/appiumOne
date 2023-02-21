package page;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopBarPage extends BasePage {
    private final By topMenu = new AppiumBy.ByAccessibilityId("test-Menu");
    private final By cartMenu = new AppiumBy.ByAccessibilityId("test-Cart");


    public TopBarPage(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageToLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(topMenu));
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(driver.findElement(topMenu).isDisplayed());
        softAssert.assertTrue(driver.findElement(cartMenu).isDisplayed());
        softAssert.assertAll();
    }


}
