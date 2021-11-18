package rozetka.tests;

import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static rozetka.logic.pages.HeaderMenu.*;
import static rozetka.logic.pages.MainPage.*;

@Listeners(UIListener.class)
public class HeaderMenuTests extends BaseUITest {

    @DataProvider(name = "authEmailData")
    public Object[][] authEmailData() {
        return new Object[][]{
                {"email"},
                {"realemail@"},
                {"reallyrealemail@yes"},
                {"@yes.com"}
        };
    }

    @Test
    @Description(value = "Check returning to main page via logo")
    public void checkReturningToMainPage() {
        selectItemByIndex(itemIndexToSelect);
        returnToMainPage();
    }

    @Test(dataProvider = "authEmailData")
    @Description(value = "Check invalid email error in auth form")
    public void checkInvalidAuthEmail(String email) {
        openAuthForm();
        checkWrongEmailError(email);
    }

    @Test
    @Description(value = "Check if the cart is empty")
    public void checkCartIsEmpty() {
        openCart();
        checkEmptyCart();
    }

    @Test
    @Description(value = "Check amount of categories")
    public void checkCategoryAmount() {
        checkAmountOfCategories();
    }

    @Test
    @Description(value = "Check if password input supports uncovering text in auth form")
    public void checkPasswordInputTypeSwitch() {
        openAuthForm();
        checkPasswordToVisible();
    }

    @Test
    @Description(value = "Check changing language to UA")
    public void checkChangingLangToUA() {
        changeLangToUA();
    }

    @Test
    @Description(value = "Check opening of register form")
    public void checkAuthRegisterForm() {
        openRegisterForm();
    }
}
