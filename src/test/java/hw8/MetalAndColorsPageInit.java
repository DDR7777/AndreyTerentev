package hw8;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.init.PageFactory;
import entity.User;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.JDIsite.JDISite;

import static pages.JDIsite.JDISite.homePage;
import static pages.JDIsite.JDISite.login;

public class MetalAndColorsPageInit {

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        PageFactory.initSite(JDISite.class);
        WebPage.openSite();
        homePage.checkOpened();
        login(new User());
    }

    @AfterSuite
    public static void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }
}
