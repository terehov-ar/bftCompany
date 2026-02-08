package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectsPage {

    private final SelenideElement pageHeader = $(".produktFront-content");


    @Step("Открываем страницу проектов компании")
    public ProjectsPage openPage() {
        open("projects/");

        return this;
    }

    @Step("Получить текущий url")
    public String getCurrentUrl() {

        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    @Step("Проверка заголовка страницы")
    public ProjectsPage checkHeaderName(String headerName) {
        pageHeader.shouldHave(text(headerName));

        return this;
    }
}
