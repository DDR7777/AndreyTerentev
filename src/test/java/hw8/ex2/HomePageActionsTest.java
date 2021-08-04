package hw8.ex2;

import base.AllureAttachmentListener;
import base.BaseTest;
import org.testng.annotations.*;
import pages.DifferentElementsPage;
import pages.HomePage;

@Listeners(AllureAttachmentListener.class)
public class HomePageActionsTest extends BaseTest {

    @Test
    public void homePageActionsTest() {
        // 1 Open test site by URL
        HomePage homePage = new HomePage(driver);
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver);
        homePage.navigate();

        // 2 Assert Browser title
        homePage.checkPageTitle("Home Page");

        // 3 Perform login
        homePage.login(name, password);

        // 4 Assert Username is loggined
        homePage.checkUserIsLoggined(fullname);

        // 5 Open through the header menu Service -> Different Elements Page
        homePage.openDifferentElementsPage();
        // 6 Select checkboxes
        // 7 Select radio
        // 8 Select in dropdown
        differentElementsPage.clickCheckbox("Water");
        differentElementsPage.clickCheckbox("Wind");
        differentElementsPage.clickRadioButton("Selen");
        differentElementsPage.selectDropdownItem("Yellow");

        // 9 Select in dropdown
        differentElementsPage.checkLogIsDisplayed("Water", "true");
        differentElementsPage.checkLogIsDisplayed("Wind", "true");
        differentElementsPage.checkLogIsDisplayed("metal", "Selen");
        differentElementsPage.checkLogIsDisplayed("Colors", "Yellow");
    }

    // 10 Close Browser

}



