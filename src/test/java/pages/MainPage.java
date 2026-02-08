package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement buttonContact = $(".header-panel__callback"),
            inputName = $("[name='name']"),
            inputPhone = $("[name='phone']"),
            inputRegion = $("[name='region']"),
            inputComment = $("[name='text']"),
            buttonSearch = $("button.header-panel__search.jsSearch"),
            placeholderSearch = $("[placeholder='Поиск по сайту']"),
            searchSubmit = $(".search-wrap__submit"),
            resultList = $("#resheniya-result"),
            headerPage = $(".header-bottom__menu.menu-desktop"),
            buttonCareer = $(".btn.btn--red.btn--transparent.frontTeam__vacancy"),
            buttonPortfolio =  $(".btn.btn--white.frontPortfolio--link"),
            buttonVK =  $("#bx_3099439860_39181"),
            buttonSubmitContact =  $(".btn.btn--red.btn--transparent.modalContent-btn").$(byText("Отправить")),
            organizationValidationInput =  $("#organization-error");

    private final ElementsCollection inputsEmail = $$("[name='email']");
    private final ElementsCollection dropdownElements = $$("ul.linkedMenu-list");

    @Step("Открываем главную страницу")
    public MainPage openPage() {
        open("");

        return this;
    }

    @Step("Нажимаем на кнопку 'Написать нам'")
    public MainPage openContactForm() {
        buttonContact.click();

        return this;
    }

    @Step("Заполняем поле 'Полное ФИО'")
    public MainPage setName(String value) {
        inputName.setValue(value);

        return this;
    }

    @Step("Заполняем поле 'E-mail'")
    public MainPage setEmail(String value) {
        inputsEmail.get(1).setValue(value);

        return this;
    }

    @Step("Заполняем поле 'Номер телефона'")
    public MainPage setNumber(String value) {
        inputPhone.setValue(value);

        return this;
    }

    @Step("Заполняем поле 'Регион'")
    public MainPage setAddress(String value) {
        inputRegion.setValue(value);

        return this;
    }

    @Step("Нажимаем на кнопку 'Отправить' на форме обратной связи")
    public MainPage pressButtonSubmitContact() {
        buttonSubmitContact.click();

        return this;
    }

    @Step("Проверяем отображение валидации поля 'Наименование организации'")
    public MainPage checkValidationInputCompany() {
        organizationValidationInput.shouldHave(attribute("class", "error"));

        return this;
    }

    @Step("Заполняем поле 'Введите текст'")
    public MainPage setComment(String value) {
        inputComment.setValue(value);

        return this;
    }

    @Step("Нажимаем на кнопку поиска")
    public MainPage openSearch() {
        buttonSearch.click();

        return this;
    }

    @Step("Заполняем поле поиска")
    public MainPage setSearchText(String value) {
        placeholderSearch.setValue(value);

        return this;
    }

    @Step("Нажимаем на стрелочку для поиска")
    public MainPage pressSearch() {
        searchSubmit.click();

        return this;
    }

    @Step("Проверяем наличие записи в результатах поиска 'Контакты службы техподдержки'")
    public MainPage assertResult(String value) {
        resultList.shouldHave(text(value));

        return this;
    }

    @Step("Наводим на заголовок")
    public MainPage hoverHeader(String header) {
        headerPage.$(byText(header)).hover();

        return this;
    }

    @Step("Проверяем открытие и ищем элемент выпадающего списка")
    public MainPage checkOpenDropdown(String elementOfDropdown) {
        dropdownElements.find(text(elementOfDropdown)).should(exist);

        return this;
    }

    @Step("Нажимаем на кнопку 'Вакансии и карьера'")
    public MainPage buttonCareerTakeToNextPage(String jobInfo) {
        buttonCareer.shouldHave(text(jobInfo)).click();

        return this;
    }

    @Step("Получить текущий url")
    public String getCurrentUrl() {

        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    @Step("Нажимаем на кнопку 'Вакансии и карьера'")
    public MainPage buttonProjectInfoTakeToNextPage(String projectInfo) {
        buttonPortfolio.shouldHave(text(projectInfo)).click();

        return this;
    }

    @Step("Нажимаем на логотип 'ВК'")
    public MainPage pressVkButton() {
        buttonVK.click();
        Selenide.switchTo().window(1);

        return this;
    }
}
