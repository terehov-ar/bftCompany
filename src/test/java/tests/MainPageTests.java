package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.WebDriverRunner;
import pages.MainPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("smoke")
public class MainPageTests extends TestBase{

    MainPage page = new MainPage();

    @Test
    void fillContactFormTest() {
        page.openPage()
                .openContactForm()
                .setName()
                .setEmail()
                .setNumber()
                .setAddress()
                .setCompany()
                .setComment();
        //add Assert
    }

    @Test
    void searchTest() {
        page.openPage()
                .openSearch()
                .setSearchText()
                .pressSearch()
                .assertResult();
        //add Assert
    }

    @CsvFileSource(resources = "/test_data/listOfHeaderMainPage.csv")
    @ParameterizedTest(name = "При выборе заголовка {0} под ним должен открываться выпадающий список, содержащий как минимум элемент {1}")
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
    public void buttonVK() {
        String urlVK = "https://vk.com/bftcom";
        page.openPage()
                .pressVkButton();

        assertEquals(urlVK, page.getCurrentUrl());
    }
}
