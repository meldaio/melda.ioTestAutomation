import base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

import java.time.Duration;


public class RegisterTest extends BaseTest {
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Test(description = "Kullanıcı Oluşturma Kontrolü")
    public void registerTest() {

            String usermail = createUserMail();
            homePage.clickRegister();
            registerPage.registerWithEmailDemoVerification();
            // Başlık metnini kontrol etme
        homePage.accountControl("Select Workspace");

    }
}











