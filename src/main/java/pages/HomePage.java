package pages;

import base.BaseTest;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BaseTest {

    @Step("Kullanıcı Kontrolü")
    public HomePage accountControl(String value) {
        // "h1" etiketinin metnini almak için .getText() ekliyoruz
        String text = driver.findElement(By.tagName("h1")).getText();

        // Beklenen ve gerçek değerleri karşılaştırıyoruz
        Assert.assertEquals(value, text);

        return this;

    }
    @Step("Register linki tıklanır")
    public HomePage clickRegister() {
        driver.findElement(By.xpath("//a[@title='Sign up' or @title='Kaydol']")).click();
        return this;
        // Bu satır, method chaining (yöntem zincirleme) için LoginPage nesnesini geri döndürür
    }
}
