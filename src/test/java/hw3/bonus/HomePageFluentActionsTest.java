package hw3.bonus;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DifferentElementsPage;
import pages.DifferentElementsPageFluent;
import pages.HomePage;
import pages.HomePageFluent;

import java.util.concurrent.TimeUnit;

public class HomePageFluentActionsTest extends BaseTest {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void homePageContentTest() {
        SoftAssert softAssert = new SoftAssert();
        // 1 Open test site by URL
        HomePageFluent homePage = new HomePageFluent(driver).navigate();


        // 2 Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page", "Browser title");

        // 3 Perform login
        homePage.login(name, password);

        // 4 Assert Username is loggined
        softAssert.assertEquals(homePage.fullname.getText(), fullname);

        // 5 Open through the header menu Service -> Different Elements Page
        // 6 Select checkboxes
        // 7 Select radio
        // 8 Select in dropdown
        DifferentElementsPageFluent differentElementsPage = homePage.openDifferentElementsPage()
                .clickCheckbox("Water")
                .clickCheckbox("Wind")
                .clickRadioButton("Selen")
                .selectDropdownItem("Yellow");

        // 9 Select in dropdown
        Assert.assertTrue(differentElementsPage.isLogDisplayed("Water", "true"));
        Assert.assertTrue(differentElementsPage.isLogDisplayed("Wind", "true"));
        Assert.assertTrue(differentElementsPage.isLogDisplayed("metal", "Selen"));
        Assert.assertTrue(differentElementsPage.isLogDisplayed("Colors", "Yellow"));
    }

    // 10 Close Browser
    @AfterMethod
    public void afterMethod() {
        driver.close();
    }
}
