package rozetka.logic.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;

public class HeaderMenu {

    private static final By searchInput = By.name("search");
    private static final By searchButton = By.xpath("//button[text()=' Найти ']");
    private static final By logoImage = By.cssSelector("body > app-root > div > div > rz-header > header > div > div > a > picture > img");
    private static final By authButton = By.xpath("/html/body/app-root/div/div/rz-header/header/div/div/ul/li[3]/rz-user/button");
    private static final By authFormTitle = By.xpath("//single-modal-window/div/div/h3[@class='modal__heading']");
    private static final By authEmailInput = By.xpath("//input[@id='auth_email']");
    private static final By authPasswordInput = By.xpath("//input[@id='auth_pass']");
    private static final By errorMessage = By.xpath("//p[@class='error-message ng-star-inserted']");
    private static final By cartButton = By.xpath("//rz-cart/button");
    private static final By cartWindow = By.xpath("/html/body/app-root/single-modal-window/div[2]");
    private static final By cartWindowBodyTitle = By.cssSelector("h4.cart-dummy__heading");
    private static final By switchPasswordInputTypeButton = By.xpath("//rz-user-identification/rz-auth/div/form/fieldset/div[2]/div/div/button");
    private static final By langButtonUA = By.xpath("/html/body/app-root/div/div/rz-header/header/div/div/ul/li[1]/rz-lang/ul/li[2]/a");
    private static final By registerButtonInAuthForm = By.xpath("//rz-user-identification/rz-auth/div/form/fieldset/div[5]/button[2]");

    @Step(value = "Searching {input} via search input")
    public static void searchItem(String input) {
        $(searchInput).sendKeys(input);
        $(searchButton).click();
    }

    @Step(value = "Click on logo")
    public static void returnToMainPage() {
        $(logoImage).shouldBe(Condition.visible).click();
        Assert.assertEquals(title(), "Интернет-магазин ROZETKA™: официальный сайт самого популярного онлайн-гипермаркета в Украине");
    }

    @Step(value = "Opening auth form")
    public static void openAuthForm() {
        $(authButton).click();
        SelenideElement formTitle = $(authFormTitle).shouldBe(Condition.visible);
        Assert.assertEquals(formTitle.getText(), "Вход");
    }

    @Step(value = "Check wrong email error with {email} input")
    public static void checkWrongEmailError(String email) {
        $(authEmailInput).sendKeys(email);
        $(authPasswordInput).click();
        SelenideElement error = $(errorMessage).shouldBe(Condition.visible);
        Assert.assertEquals(error.getText(), "Введен неверный адрес эл.почты или номер телефона");
    }

    @Step(value = "Opening cart")
    public static void openCart() {
        $(cartButton).click();
        $(cartWindow).shouldBe(Condition.visible);
    }

    @Step(value = "Checking cart is empty")
    public static void checkEmptyCart() {
        Assert.assertEquals($(cartWindowBodyTitle).getText(), "Корзина пуста");
    }

    @Step(value = "Checking hiding password button")
    public static void checkPasswordToVisible() {
        SelenideElement passwordInput = $(authPasswordInput);
        passwordInput.sendKeys("test");
        $(switchPasswordInputTypeButton).click();
        Assert.assertEquals(passwordInput.getAttribute("type"), "text");
    }

    @Step(value = "Changing language to UA")
    public static void changeLangToUA() {
        $(langButtonUA).click();
        Assert.assertEquals($(searchInput).getAttribute("placeholder"), "Я шукаю...");
    }

    @Step(value = "Opening register form from login form")
    public static void openRegisterForm() {
        openAuthForm();
        $(registerButtonInAuthForm).click();
        SelenideElement formTitle = $(authFormTitle).shouldBe(Condition.visible);
        Assert.assertEquals(formTitle.getText(), "Регистрация");
    }
}
