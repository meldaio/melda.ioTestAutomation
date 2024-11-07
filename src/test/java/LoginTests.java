import base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MainPage;


import java.time.Duration;

public class LoginTests extends BaseTest {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    MainPage mainPage = new MainPage();

    @Test (description = "Başarısız Kullanıcı Girişi Kontrolü")
    public void loginWithWrongCredentials() {
        try {
            WebElement signInLink = driver.findElement(By.cssSelector("a[href='/login']")); // Login linkini bul
            signInLink.click(); // Linke tıklayarak login sayfasına git
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 saniye bekle
            WebElement newPageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))); // Sayfanın yüklenmesini bekle

            loginPage.fillUsermail("test"); // Hatalı kullanıcı adı gir
            loginPage.fillPassword("deneme"); // Hatalı şifre gir
            loginPage.clickLoginButton(); // Giriş butonuna tıkla
            mainPage.errorControlMessage("User account is not found or password is incorrect."); // Hata mesajını kontrol et
        } catch (Exception e) {
            System.out.println("\u001B[31mError in loginWithWrongCredentials: " + e.getMessage() + "\u001B[0m"); // Hata mesajını yazdır
        }
    }

    @Test (description = "Başarılı Giriş Kontrolü")
    public void loginWithCorrectCredentials() {
        try {
            final String GREEN = "\033[32m"; // Başarılı test için yeşil renk kodu
            final String RED = "\u001B[31m"; // Hatalı test için kırmızı renk kodu

            WebElement signInLink = driver.findElement(By.cssSelector("a[href='/login']")); // Login linkini bul
            signInLink.click(); // Linke tıklayarak login sayfasına git
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 saniye bekle
            WebElement newPageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))); // Sayfanın yüklenmesini bekle

            String correctpassword = System.getenv("PASSWORD"); // Şifreyi çevresel değişkenden al
            loginPage.fillUsermail(usermail); // Geçerli kullanıcı adı ile giriş yap
            loginPage.fillPassword(correctpassword); // Geçerli şifreyi gir
            loginPage.clickLoginButton(); // Giriş butonuna tıkla

            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 saniye bekle
            WebElement header = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1"))); // Başlık öğesini bul
            homePage.accountControl("Select Workspace"); // Workspace seçimi kontrolü

            String text = header.getText(); // Başlık metnini al
            System.out.println("Workspace metni: " + text); // Başlık metnini yazdır

            if (text.equals("Select Workspace")) { // Başlık doğru mu diye kontrol et
                System.out.println(GREEN + "Başlık doğru: Select Workspace" + "\u001B[0m"); // Başlık doğruysa yeşil yazdır
            } else {
                System.out.println(RED + "Başlık yanlış: " + text + "\u001B[0m"); // Başlık yanlışsa kırmızı yazdır
            }
        } catch (Exception e) {
            System.out.println("\u001B[31mError in loginWithCorrectCredentials: " + e.getMessage() + "\u001B[0m"); // Hata mesajını yazdır
        }
    }

    @Test (description = "Zorunluluk Kontrolü")
    public void loginRequiredControl() {
        try {
            final String RED = "\u001B[31m"; // Kırmızı renk kodu
            final String GREEN = "\033[32m"; // Yeşil renk kodu
            final String RESET = "\u001B[0m"; // Renk sıfırlama

            WebElement signInLink = driver.findElement(By.cssSelector("a[href='/login']")); // Login linkini bul
            signInLink.click(); // Linke tıklayarak login sayfasına git
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 saniye bekle
            WebElement newPageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))); // Sayfanın yüklenmesini bekle

            loginPage.fillUsermail(""); // Email alanını boş bırak
            loginPage.fillPassword(""); // Şifre alanını boş bırak
            loginPage.clickLoginButton(); // Giriş butonuna tıkla

            driver.findElement(By.cssSelector("div#app button[type='button']")).click(); // Butona tıkla
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 saniye bekle
            WebElement alertElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='alert alert-danger']"))); // Hata mesajını bekle

            String text = alertElement.getText(); // Hata mesajını al
            System.out.println(RED + text + RESET); // Hata mesajını yazdır

            Assert.assertEquals("User account is not found or password is incorrect.", text); // Hata mesajını doğrula
            if (text.equals("User account is not found or password is incorrect.")) { // Hata mesajı doğruysa
                System.out.println(GREEN + "Gerekli alan boş bırakıldığından giriş yapılmadı." + "\u001B[0m"); // Mesajı yeşil yazdır
            } else {
                System.out.println("Gerekli alan girilmediği hâlde giriş sağlandı."); // Mesaj yanlışsa yazdır
            }
        } catch (Exception e) {
            System.out.println("\u001B[31mError in loginRequiredControl: " + e.getMessage() + "\u001B[0m"); // Hata mesajını yazdır
        }
    }

    @Test (description = "Eksik Şifre Giriş Kontrolü" )
    public void emptyPasswordTest() {
        try {
            final String RED1 = "\u001B[31m"; // Kırmızı renk kodu
            final String GREEN1 = "\033[32m"; // Yeşil renk kodu
            final String RESET1 = "\u001B[0m"; // Renk sıfırlama

            WebElement signInLink = driver.findElement(By.cssSelector("a[href='/login']")); // Login linkini bul
            signInLink.click(); // Linke tıklayarak login sayfasına git
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 saniye bekle
            WebElement newPageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))); // Sayfanın yüklenmesini bekle

            driver.findElement(By.name("email")).sendKeys("nenem34921@aleitar.com"); // Email alanını doldur
            driver.findElement(By.name("password")).sendKeys(""); // Şifreyi boş bırak

            driver.findElement(By.cssSelector("div#app button[type='button']")).click(); // Giriş butonuna tıkla
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 saniye bekle
            WebElement alertElement1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='alert alert-danger']"))); // Hata mesajını bekle

            String text1 = alertElement1.getText(); // Hata mesajını al
            System.out.println(RED1 + text1 + RESET1); // Hata mesajını yazdır

            Assert.assertEquals("User account is not found or password is incorrect.", text1); // Hata mesajını doğrula
            if (text1.equals("User account is not found or password is incorrect.")) { // Hata mesajı doğruysa
                System.out.println(GREEN1 + "Gerekli alan boş bırakıldığından giriş yapılmadı." + "\u001B[0m"); // Mesajı yeşil yazdır
            } else {
                System.out.println("Gerekli alan girilmediği hâlde giriş sağlandı."); // Mesaj yanlışsa yazdır
            }
        } catch (Exception e) {
            System.out.println("\u001B[31mError in emptyPasswordTest: " + e.getMessage() + "\u001B[0m"); // Hata mesajını yazdır
        }
    }


    @Test (description = "Eksik Şifre Giriş Kontrolü")
    public void emptyemailTest() {
        final String RED1 = "\u001B[31m";
        final String GREEN1 = "\033[32m";
        final String RESET1 = "\u001B[0m"; // Renkleri sıfırlamak için

        try {
            // Giriş sayfasına yönlendiren linke tıklama
            WebElement signInLink = driver.findElement(By.cssSelector("a[href='/login']"));
            signInLink.click();

            // Yeni sayfanın yüklenmesini bekliyoruz (email input görünene kadar)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement newPageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));

            // Email ve şifre alanlarını boş bırak
            driver.findElement(By.name("email")).sendKeys("");
            driver.findElement(By.name("password")).sendKeys("123452");

            // Giriş butonuna tıkla
            driver.findElement(By.cssSelector("div#app button[type='button']")).click();
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement alertElement1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='alert alert-danger']")));

            // Hata mesajını al
            String text1 = alertElement1.getText();
            System.out.println(RED1 + text1 + RESET1);

            // Hata mesajını doğrula
            Assert.assertEquals("User account is not found or password is incorrect.", text1);
            if (text1.equals("User account is not found or password is incorrect.")) {
                System.out.println(GREEN1 + "Gerekli alan boş bırakıldığından giriş yapılmadı." + "\u001B[0m");
            } else {
                System.out.println("Gerekli alan girilmediği hâlde giriş sağlandı.");
            }
        } catch (Exception e) {
            // Hata mesajını yazdır
            System.out.println("\u001B[31mError in emptyemailTest: " + e.getMessage() + "\u001B[0m");
        }
    }
}

