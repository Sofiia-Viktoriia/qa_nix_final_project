package rozetka.logic.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ItemPage {

    private static final By itemPicture = By.xpath("//img[@class='picture-container__picture']");
    private static final By itemTitle = By.xpath("//h1[@class='product__title']");
    private static final By buyButton = By.xpath("//app-product-buy-btn/app-buy-button/button");
    private static final By itemMenu = By.xpath("//rz-product-navbar/rz-tabs/div/div/ul/li/a");

    @Step(value = "Checking title presence")
    public static void checkTitlePresence() {
        $(itemPicture).shouldBe(Condition.visible);
        SelenideElement title = $(itemTitle);
        Assert.assertNotEquals("", title.getText());
    }

    @Step(value = "Checking buy button title")
    public static void checkTitleOfBuyButton() {
        Assert.assertEquals($(buyButton).getText(), "Купить");
    }

    @Step(value = "Checking buy button title in UA")
    public static void checkTitleOfBuyButtonInUA() {
        Assert.assertEquals($(buyButton).getText(), "Купити");
    }

    @Step(value = "Check {optionIndex}-th option of menu has title {expectedTitle}")
    public static void checkItemMenuTitle(int optionIndex, String expectedTitle) {
        List<SelenideElement> menuOptions = $$(itemMenu);
        Assert.assertTrue(menuOptions.get(optionIndex).getText().contains(expectedTitle));
    }
}
