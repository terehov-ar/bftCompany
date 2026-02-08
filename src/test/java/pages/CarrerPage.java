package pages;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

public class CarrerPage {

    @Step("Получить текущий url")
    public String getCurrentUrl() {

        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }
}
