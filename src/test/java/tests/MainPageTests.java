package tests;

import data.TestData;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.MainPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("smoke")
public class MainPageTests extends TestBase {

    MainPage page = new MainPage();
    TestData testData = new TestData();

    @Test
    void notFullFillContactFormTest() {
        page.openPage()
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
    void searchTestShouldContainResult() {
        String searchText = "Контакты службы техподдержки";
        page.openPage()
                .openSearch()
                .setSearchText(searchText)
                .pressSearch()
                .assertResult(searchText);
    }

    @CsvFileSource(resources = "/test_data/listOfHeaderMainPage.csv")
    @ParameterizedTest(name = "При выборе заголовка {0} под ним должен открываться выпадающий список, содержащий элемент {1}")
    void dropdownShouldOpenAndContainElement(String header, String elementOfDropdown) {
        page.openPage()
                .hoverHeader(header)
                .checkOpenDropdown(elementOfDropdown);
    }

    @Test
    public void buttonCareerTakeToNextPage() {
        String urlCareer = "https://bft.ru/career/";
        page.openPage()
                .buttonCareerTakeToNextPage();
        assertEquals(urlCareer, page.getCurrentUrl());
    }

    @Test
    public void buttonInfoProjectTakeToNextPage() {
        String urlProjects = "https://bft.ru/projects/";
        page.openPage()
                .buttonProjectInfoTakeToNextPage();
        assertEquals(urlProjects, page.getCurrentUrl());
    }

    @Test
    public void buttonVKTakeToVK() {
        String urlVK = "https://vk.com/bftcom";
        page.openPage()
                .pressVkButton();

        assertEquals(urlVK, page.getCurrentUrl());
    }
}
