package base;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class BaseLibrary extends Data {
    public static WebDriver driver;

    public String createUserMail()
    {
        Random random= new Random();

        String usermail = "test" + random.nextInt(10000) +"@hotmail.com";
        return usermail;

    }
    @Attachment(value = "Screenshot", type="imahe/png")
    public byte [] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
    }

