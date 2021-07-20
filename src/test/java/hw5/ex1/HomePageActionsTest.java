package hw5.ex1;

import base.AllureAttachmentListener;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.DifferentElementsPage;
import pages.HomePage;
import steps.SiteSteps;

//@Listeners(AllureAttachmentListener.class)
public class HomePageActionsTest extends BaseTest {

    @Test
    public void homePageActionsTest() {
        // 1 Open test site by URL
        SiteSteps siteSteps = new SiteSteps();
        //DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver);
        siteSteps.openHomePage();

        // 2 Assert Browser title
        siteSteps.checkPageTitle("Home Page");

        // 2 Perform login
        siteSteps.userLogin();

        // 4 Assert Username is loggined
        siteSteps.checkUserIsLoggined(fullname);

        // 3 Open through the header menu Service -> Different Elements Page
        siteSteps.openDifferentElementsPage();
        siteSteps.checkPageTitle("Different Elements");


        // 4 Select checkboxes
        siteSteps.clickCheckbox("Water");
        siteSteps.clickCheckbox("Wind");

        // 5 Select radio
        siteSteps.clickRadioButton("Selen");

        // 6 Select in dropdown
        siteSteps.selectDropdownItem("Yellow");

        // 7 Select in dropdown
        siteSteps.checkLogIsDisplayed("Water", "true");
        siteSteps.checkLogIsDisplayed("Wind", "true");
        siteSteps.checkLogIsDisplayed("metal", "Selen");
        siteSteps.checkLogIsDisplayed("Colors", "Yellow");

        // 10 Close Browser
        siteSteps.closeDriver();
    }


}



