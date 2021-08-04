package pages.JDIsite;

import base.Utils;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import entity.MetalsAndColorsData;
import entity.User;
import enums.HeaderMenuItem;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import pages.JDIsite.pages.HomePage;
import pages.MetalAndColorsPage;
import pages.JDIsite.sections.Header;
import pages.JDIsite.sections.LoginForm;
import pages.JDIsite.sections.ResultSection;
import base.Utils;

import static org.testng.Assert.assertEquals;

@JSite("https://epam.github.io/JDI/")
public class JDISite extends WebSite {

    public static HomePage homePage;
    public static Header header;
    public static LoginForm loginForm;
    public static MetalAndColorsPage metalAndColorsPage;
    public static ResultSection resultSection;

    @FindBy(css = ".profile-photo")
    public static Label profilePhoto;

    //methods
    @Step
    public static void login(User user) {
        profilePhoto.click();
        loginForm.loginAs(user);
    }

    @Step
    public static void chooseHeaderMenu(HeaderMenuItem item) {
        header.headerMenu.select(item);
    }

    //checks
    @Step
    public static void checkResultSectionContainsData(MetalsAndColorsData expectedData) {
        assertEquals(resultSection.results.getTextList(), Utils.getExpectedResults(expectedData));
    }
}
