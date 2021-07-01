package hw3.ex2;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.DifferentElementsPage;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

    public class HomePageActionsTest extends BaseTest {
        WebDriver driver;
        HomePage homePage;
        DifferentElementsPage differentElementsPage;

        @BeforeMethod
        public void beforeMethod() {
            driver = new ChromeDriver();
            homePage = PageFactory.initElements(driver, HomePage.class);
            differentElementsPage = PageFactory.initElements(driver, DifferentElementsPage.class);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }

        @Test
        public void homePageContentTest() {
            SoftAssert softAssert = new SoftAssert();
            // 1 Open test site by URL
            driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

            // 2 Assert Browser title
            softAssert.assertEquals(driver.getTitle(), "Home Page", "Browser title");

            // 3 Perform login
            homePage.login("Roman", "Jdi1234");

            // 4 Assert Username is loggined
            softAssert.assertEquals(homePage.fullname.getText(), "ROMAN IOVLEV");

            // 5 Open through the header menu Service -> Different Elements Page
            homePage.headerMenuService.click();
            homePage.differentElementItem.click();

            // 6 Select checkboxes
            differentElementsPage.getCheckbox("Water").click();
            differentElementsPage.getCheckbox("Wind").click();

            // 7 Select radio
            differentElementsPage.getRadioButton("Selen").click();

            // 8 Select in dropdown
            differentElementsPage.selectDropdownItem("Yellow");

            // 9 Select in dropdown
            Assert.assertTrue(differentElementsPage.getLog("Water", "true").isDisplayed());
            Assert.assertTrue(differentElementsPage.getLog("Wind", "true").isDisplayed());
            Assert.assertTrue(differentElementsPage.getLog("metal", "Selen").isDisplayed());
            Assert.assertTrue(differentElementsPage.getLog("Colors", "Yellow").isDisplayed());
        }

        // 10 Close Browser
        @AfterMethod
        public void afterMethod(){
            driver.close();
        }
    }



