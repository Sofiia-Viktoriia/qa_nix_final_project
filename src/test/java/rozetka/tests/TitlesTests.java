package rozetka.tests;

import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static rozetka.logic.pages.HeaderMenu.*;
import static rozetka.logic.pages.ItemPage.*;
import static rozetka.logic.pages.MainPage.*;
import static rozetka.logic.pages.SearchPage.*;

@Listeners(UIListener.class)
public class TitlesTests extends BaseUITest {

    @DataProvider(name = "searchItemDataUA")
    public static Object[][] searchItemDataUA() {
        return new Object[][]{
                {"вафельница", "Вафельниці"},
                {"телефон", "Мобільні телефони"},
                {"ноутбук", "Ноутбуки"},
                {"наушники", "Навушники"}
        };
    }

    @DataProvider(name = "searchItemData")
    public static Object[][] searchItemData() {
        return new Object[][]{
                {"вафельница", "Вафельницы"},
                {"телефон", "Мобильные телефоны"},
                {"ноутбук", "Ноутбуки"},
                {"наушники", "Наушники"}
        };
    }

    @DataProvider(name = "itemMenuTitles")
    public static Object[][] itemMenuTitles() {
        return new Object[][]{
                {0, "Все о товаре"},
                {1, "Характеристики"},
                {2, "Отзывы"},
                {3, "Вопросы"},
                {4, "Видео"},
                {5, "Фото"},
                {6, "Покупают вместе"}
        };
    }

    @DataProvider(name = "itemMenuTitlesUA")
    public static Object[][] itemMenuTitlesUA() {
        return new Object[][]{
                {0, "Усе про товар"},
                {1, "Характеристики"},
                {2, "Відгуки"},
                {3, "Питання"},
                {4, "Відео"},
                {5, "Фото"},
                {6, "Купують разом"}
        };
    }

    @Test
    @Description(value = "Check if title presented on item page")
    public void checkItemTitlePresence() {
        selectItemByIndex(itemIndexToSelect);
        checkTitlePresence();
    }

    @Test(dataProvider = "searchItemData")
    @Description(value = "Check if title of searched items is correct")
    public void checkSearchItemsTitle(String search, String title) {
        searchItem(search);
        checkSearchTitle(title);
    }

    @Test
    @Description(value = "Check if buy button title is correct")
    public void checkBuyButtonTitle() {
        selectItemByIndex(itemIndexToSelect);
        checkTitleOfBuyButton();
    }

    @Test
    @Description(value = "Check if buy button title is correct in UA")
    public void checkBuyButtonTitleInUA() {
        changeLangToUA();
        selectItemByIndex(itemIndexToSelect);
        checkTitleOfBuyButtonInUA();
    }

    @Test(dataProvider = "searchItemDataUA")
    @Description(value = "Check if title of searched items is correct in UA")
    public void checkSearchTitleInUA(String search, String title) {
        searchItem(search);
        changeLangToUA();
        checkSearchTitle(title);
    }

    @Test(dataProvider = "itemMenuTitles")
    @Description(value = "Check if titles of menu are correct on item page")
    public void checkItemMenuTitles(int optionIndex, String expectedTitle) {
        selectItemByIndex(itemIndexToSelect);
        checkItemMenuTitle(optionIndex, expectedTitle);
    }

    @Test(dataProvider = "itemMenuTitlesUA")
    @Description(value = "Check if titles of menu are correct on item page in UA")
    public void checkItemMenuTitlesInUA(int optionIndex, String expectedTitle) {
        changeLangToUA();
        selectItemByIndex(itemIndexToSelect);
        checkItemMenuTitle(optionIndex, expectedTitle);
    }
}
