package pages;

import base.BaseTest;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BaseTest {
@Step("Hata Mesajı Kontrolü")
    public MainPage errorControlMessage(String message)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*='alert-danger']")));

        String text = errorMessageElement.getText();
        System.out.println("Expected message: " + message);
        System.out.println("Actual message: " + text);

        Assert.assertEquals(message, text);
        screenshot();
        return this;
    }


}
