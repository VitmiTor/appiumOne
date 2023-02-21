package firstTest;

import base.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import page.LoginPage;
import page.TopBarPage;

public class LoginTests extends BaseTest {
    private LoginPage loginPage;
    private TopBarPage topBarPage;

    @Test
    public void validCredentials() {
        final var validCredentials = dataGiver.getValidCredentials();
        loginPage.waitPageToLoad();
        loginPage.fillingform(validCredentials.getUsername(), validCredentials.getPassword());
        topBarPage.waitPageToLoad();
    }

    @Test
    public void invalidCredentialsTest() throws InterruptedException {
        final var invalidCredentials = dataGiver.getInValidCredentials();
        loginPage.waitPageToLoad();
        loginPage.fillingform(invalidCredentials.getUsername(), invalidCredentials.getPassword());
        loginPage.verifyErrorMesage(dataGiver.getInvalidErrorText().getErrorMessage());
    }

    @Test
    public void lockedUserTest() {
        final var lockedUserCredentials = dataGiver.getLockedCredentials();
        loginPage.waitPageToLoad();
        loginPage.fillingform(lockedUserCredentials.getUsername(), lockedUserCredentials.getPassword());
        loginPage.verifyErrorMesage(dataGiver.getLockedErrorText());
    }

    @Test
    public void lockedUSerTapTest() {
        
        loginPage.scrollLockedOutUserLogin();
        loginPage.clickOnLogin();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException interruptedException) {
            interruptedException.getLocalizedMessage();
        }
    }

    //2:09:54
    @Override
    public void initPages(AndroidDriver driver) {
        loginPage = new LoginPage(driver);
        topBarPage = new TopBarPage(driver);
    }
}
