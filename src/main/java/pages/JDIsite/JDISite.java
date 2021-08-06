package pages.JDIsite;

import base.Utils;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.ui.html.elements.common.Text;
import entity.MetalsAndColorsData;
import entity.User;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import pages.JDIsite.pages.HomePage;
import pages.JDIsite.sections.Header;
import pages.JDIsite.sections.LoginForm;
import pages.JDIsite.sections.ResultSection;
import pages.MetalAndColorsPage;

import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JDISite {

    public static HomePage homePage;
    public static Header header;
    public static LoginForm loginForm;
    public static MetalAndColorsPage metalAndColorsPage;
    public static ResultSection resultSection;

    @FindBy(css = ".profile-photo")
    public static UIElement profilePhoto;

    //methods
    @Step
    public static void login(User user) {
        profilePhoto.click();
        loginForm.submit(user);
    }

    @Step
    public static void chooseHeaderMenu(String item) {
        header.headerMenu.select(item);
    }

    //checks
    @Step
    public static void checkResultSectionContainsData(MetalsAndColorsData expectedData) {
        assertEquals(resultSection.results.stream().map(Text::getValue).collect(Collectors.toList()), Utils.getExpectedResults(expectedData));
    }
}
