package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import data.TestData;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPage {

    TestData testData = new TestData();

    private final SelenideElement buttonContact = $(".header-panel__callback"),
            inputName = $("[name='name']"),
            inputPhone = $("[name='phone']"),
            inputRegion = $("[name='region']"),
            inputOrganization = $("[name='organization']"),
            inputComment = $("[name='text']"),
            buttonSearch = $("button.header-panel__search.jsSearch"),
            placeholderSearch = $("[placeholder='Поиск по сайту']"),
            searchSubmit = $(".search-wrap__submit"),
            resultList = $("#resheniya-result"),
            headerPage = $(".header-bottom__menu.menu-desktop"),
            buttonCareer = $(".btn.btn--red.btn--transparent.frontTeam__vacancy"),
            buttonPortfolio =  $(".btn.btn--white.frontPortfolio--link"),
            buttonVK =  $("#bx_3099439860_39181"),


            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitButton = $("#submit"),
            uploadAttach = $("#uploadPicture"),
            finishModal = $("#example-modal-sizes-title-lg");

    private final ElementsCollection inputsEmail = $$("[name='email']");
    private final ElementsCollection dropdownElements = $$("ul.linkedMenu-list");

    @Step("Открываем главную страницу")
    public MainPage openPage() {
        open("https://bft.ru/");

        return this;
    }

    @Step("Нажимаем на кнопку 'Написать нам'")
    public MainPage openContactForm() {
        buttonContact.click();

        return this;
    }

    @Step("Заполняем поле 'Полное ФИО'")
    public MainPage setName() {
        inputName.setValue(testData.fullName);

        return this;
    }

    @Step("Заполняем поле 'E-mail'")
    public MainPage setEmail() {
        inputsEmail.get(1).setValue(testData.email);

        return this;
    }

    @Step("Заполняем поле 'Номер телефона'")
    public MainPage setNumber() {
        inputPhone.setValue(testData.number);

        return this;
    }

    @Step("Заполняем поле 'Регион'")
    public MainPage setAddress() {
        inputRegion.setValue(testData.address);

        return this;
    }

    @Step("Заполняем поле 'Наименование организации'")
    public MainPage setCompany() {
        inputOrganization.setValue(testData.company);

        return this;
    }

    @Step("Заполняем поле 'Введите текст'")
    public MainPage setComment() {
        inputComment.setValue(testData.someText);

        return this;
    }

    @Step("Нажимаем на кнопку поиска")
    public MainPage openSearch() {
        buttonSearch.click();

        return this;
    }

    @Step("Заполняем поле поиска")
    public MainPage setSearchText() {
        placeholderSearch.setValue("Контакты службы техподдержки");

        return this;
    }

    @Step("Нажимаем на стрелочку для поиска")
    public MainPage pressSearch() {
        searchSubmit.click();

        return this;
    }

    @Step("Проверяем наличие записи в результатах поиска 'Контакты службы техподдержки'")
    public MainPage assertResult() {
        resultList.shouldHave(text("Контакты службы техподдержки"));

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
    public MainPage buttonCareerTakeToNextPage() {
        buttonCareer.shouldHave(text("Вакансии и карьера")).click();

        return this;
    }

    @Step("Получить текущий url")
    public String getCurrentUrl() {

        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    @Step("Нажимаем на кнопку 'Вакансии и карьера'")
    public MainPage buttonProjectInfoTakeToNextPage() {
        buttonPortfolio.shouldHave(text("Узнать информацию о проектах")).click();

        return this;
    }
    @Step("Нажимаем на логотип 'ВК'")
    public MainPage pressVkButton() {
        buttonVK.click();
        Selenide.switchTo().window(1);

        return this;
    }
}
