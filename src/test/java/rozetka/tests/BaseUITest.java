package rozetka.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.*;
import static rozetka.utils.BrowserProvider.getBrowser;

@Listeners(UIListener.class)
public class BaseUITest {

    protected final int itemIndexToSelect = 0;

    @BeforeSuite
    public void suiteSetUp() {
        Configuration.timeout = 10000;
        Configuration.browser = getBrowser();
        Configuration.startMaximized = true;

    }

    @BeforeMethod
    public void setUp() {
        open("https://rozetka.com.ua/");
    }

    @AfterMethod
    public void cleanUp() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] makeScreenshot() {
        return Selenide.screenshot(OutputType.BYTES);
    }
}
