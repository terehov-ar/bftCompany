package tests;

import data.TestData;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("smoke")
@Story("1829-UI")
public class MainPageTests extends TestBase {

    MainPage mainPage = new MainPage();
    TestData testData = new TestData();
    CarrerPage carrerPage = new CarrerPage();
    ProjectsPage projectsPage = new ProjectsPage();
    SocialPage socialPage = new SocialPage();

    @Test
    @Severity(SeverityLevel.MINOR)
    void notFullFillContactFormTest() {
        mainPage.openPage()
                .openContactForm()
                .setName(testData.fullName)
                .setEmail(testData.email)
                .setNumber(testData.number)
                .setAddress(testData.address)
                .setComment(testData.someText)
                .pressButtonSubmitContact()
                .checkValidationInputCompany();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    void searchTestShouldContainResult() {
        String searchText = "Контакты службы техподдержки";
        mainPage.openPage()
                .openSearch()
                .setSearchText(searchText)
                .pressSearch()
                .assertResult(searchText);
    }

    @CsvFileSource(resources = "/test_data/listOfHeaderMainPage.csv")
    @ParameterizedTest(name = "При выборе заголовка {0} под ним должен открываться выпадающий список, содержащий элемент {1}")
    @Severity(SeverityLevel.CRITICAL)
    void dropdownShouldOpenAndContainElement(String header, String elementOfDropdown) {
        mainPage.openPage()
                .hoverHeader(header)
                .checkOpenDropdown(elementOfDropdown);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void buttonCareerTakeToNextPage() {
        String urlCareer = "https://bft.ru/career/";
        mainPage.openPage()
                .buttonCareerTakeToNextPage("Вакансии и карьера");
        assertEquals(urlCareer, carrerPage.getCurrentUrl());
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void buttonInfoProjectTakeToNextPage() {
        String urlProjects = "https://bft.ru/projects/";
        mainPage.openPage()
                .buttonProjectInfoTakeToNextPage("Узнать информацию о проектах");
        assertEquals(urlProjects, projectsPage.getCurrentUrl());
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void buttonVKTakeToVK() {
        String urlVK = "https://vk.com/bftcom";
        mainPage.openPage()
                .pressVkButton();

        assertEquals(urlVK, socialPage.getCurrentUrl());
    }
}
