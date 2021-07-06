package hw4.ex1;

import base.AllureAttachmentListener;
import base.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Feature("Home Page Smoke Tests")
@Story("Home Page Action Testing")
@Listeners(AllureAttachmentListener.class)
public class HomePageContentTest extends BaseTest {
    private final List<String> headerElementsText = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");

    private final List<String> leftElementsText = Arrays.asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");


    private final List<String> imagesText = Arrays.asList("To include good practices\nand ideas from successful\nEPAM project",
            "To be flexible and\ncustomizable",
            "To be multiplatform",
            "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

       @Test
    public void homePageContentTest() {

        HomePage homePage = new HomePage(driver);

        // 1 Open test site by URL
        homePage.navigate();

        // 2 Assert Browser title
        homePage.checkPageTitle("Home Page");

        // 3 Perform login
        homePage.login(name, password);

        // 4 Assert Username is loggined
        homePage.checkUserIsLoggined(fullname);

        // 5 Assert that there are 4 items on the header section are displayed and they have proper texts
        homePage.checkHeaderElements(headerElementsText);

        // 6 Assert that there are 4 images on the Index Page and they are displayed
        homePage.checkImagesOfIndexPage(imagesText);

        // 7 Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePage.checkTextUnderImagesOnIndexPage(imagesText);

        // 8 Assert that there is the iframe with “Frame Button” exist
        homePage.checkIFrameExist();

        // 9 Switch to the iframe and check that there is “Frame Button” in the iframe
        // 10 Switch to original window
        homePage.checkFrameButtonInIframe();

        // 11 Assert left section
        homePage.checkLeftSectionOnIndexPage(leftElementsText);

        homePage.softAssertAll();

    }

}
