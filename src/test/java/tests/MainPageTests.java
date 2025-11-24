package tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.WebDriverRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPageTests {

    @BeforeEach
    @Step("Открываем страницу с формой регистрации")
    public void openPage() {
        open("https://bft.ru/");

    }

    @Test
    public void searchTest() {
        $("button.header-panel__search.jsSearch").click();
        $("[placeholder='Поиск по сайту']").setValue("Контакты службы техподдержки");
        $(".search-wrap__submit").click();
        $("#resheniya-result").shouldHave(text("Контакты службы техподдержки"));
    }

    @CsvFileSource(resources = "/test_data/listOfHeaderMainPage.csv")
    @ParameterizedTest(name = "При выборе заголовка {0} под ним должен открываться выпадающий список, содержащий как минимум элемент {1}")
    @Tag("Smoke")
    void dropdownShouldOpenAndContainElement(String header, String elementOfDropdown) {
        $(".header-bottom__menu.menu-desktop").$(byText(header)).hover();
        $$("ul.linkedMenu-list").find(text(elementOfDropdown)).should(exist);
    }

    @Test
    public void buttonCareerTakeToNextPage() {
        String url = "https://bft.ru/career/";
        $(".btn.btn--red.btn--transparent.frontTeam__vacancy").shouldHave(text("Вакансии и карьера")).click();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(url, currentUrl);

    }
}
