package rozetka.logic.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    private static final By allItems = By.xpath("//a[@class='tile__title']");
    private static final By allCategories = By.xpath("//ul[@class='menu-categories ng-star-inserted']/li");

    @Step(value = "Going to {index}-th item page")
    public static void selectItemByIndex(int index) {
        $$(allItems).get(index).click();
    }

    @Step(value = "Checking amount of categories")
    public static void checkAmountOfCategories() {
        List<SelenideElement> categories = $$(allCategories);
        Assert.assertEquals(categories.size(), 19);
    }

}
