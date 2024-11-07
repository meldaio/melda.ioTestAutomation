package pages;

import base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class RegisterPage extends BaseTest {
    @Step("E-mail girilerek demo ve aktivasyon için register olunur.")
    public RegisterPage registerWithEmailDemoVerification() {

        // WebDriverWait oluşturma
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // reCAPTCHA iframe'ine geçiş yapma
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[src*='recaptcha']")));

        // reCAPTCHA öğesinin görünür olup olmadığını kontrol etme
        WebElement captchaLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'rc-anchor-logo-img') and contains(@class, 'rc-anchor-logo-img-portrait')]")
        ));
        System.out.println("reCAPTCHA logo öğesi görünür: " + captchaLogo.isDisplayed());

        // Iframe'den çıkış
        driver.switchTo().defaultContent();

        // E-posta giriş alanını bulma ve e-posta girme
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.form-control[type='email']")));
        emailInput.sendKeys(usermail);
        driver.findElement(By.id("create-account-btn")).click();

        // `<h1>` başlık öğesinin görünmesini bekleme
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

        return this;
    }




}
