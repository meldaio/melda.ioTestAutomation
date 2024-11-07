package pages;


import base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BaseTest {
@Step("Kullanıcı e-maili girilir")
    public LoginPage fillUsermail(String text) {
        driver.findElement(By.name("email")).sendKeys(text);
        return this;
    }
@Step("Kullanıcı password alanı doldurulur.")
    public LoginPage fillPassword(String password) {

            // Şifre alanını bulup dolduruyoruz
            driver.findElement(By.name("password")).sendKeys(password);

        return this;
    }
@Step("Giriş butonuna tıklanır")
    public LoginPage clickLoginButton() {
        driver.findElement(By.cssSelector("div#app button[type='button']")).click();
        screenshot();
        return this;
    }

}
