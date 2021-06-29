package hw2.ex1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import javax.lang.model.util.Elements;
import java.sql.Driver;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePageContentTest {
    private List<String> headerElementsText = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");

    private List<String> leftElementsText = Arrays.asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");


    private List<String> imagesText = Arrays.asList("To include good practices\nand ideas from successful\nEPAM project",
            "To be flexible and\ncustomizable",
            "To be multiplatform",
            "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

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
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

        // 2 Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page", "Browser title");

        // 3 Perform login
        driver.findElement(By.cssSelector(".profile-photo")).click();

        //new WebDriverWait(driver, 20, 500).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id = 'Name']")));
        driver.findElement(By.cssSelector("[id = 'name']")).sendKeys("Roman");
        driver.findElement(By.cssSelector("[id = 'password']")).sendKeys("Jdi1234");
        driver.findElement(By.cssSelector(".login [type = 'submit']")).click();

        // 4 Assert Username is loggined
        softAssert.assertEquals(driver.findElement(By.cssSelector(".profile-photo [id = user-name]:not([class*='hidden'])")).getText(), "ROMAN IOVLEV");

        // 5 Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> headerElements = driver.findElements(By.cssSelector("ul.uui-navigation.nav > li > a"));

        softAssert.assertEquals(headerElements.size(), 4, "4 items on the header section are displayed and they have proper texts");

        for (WebElement element : headerElements) {
            softAssert.assertTrue(element.isDisplayed(), String.format("header element %s is displayed", element.getText()));
            softAssert.assertTrue(headerElementsText.contains(element.getText()), String.format("header element %s is exist", element.getText()));
        }

        // 6 Assert that there are 4 images on the Index Page and they are displayed

        List<WebElement> images = driver.findElements(By.cssSelector("span.icons-benefit"));

        softAssert.assertEquals(images.size(), 4, "4 images on the Index Page and they are displayed");

        for (WebElement image : images) {
            softAssert.assertTrue(image.isDisplayed());
        }

        // 7 Assert that there are 4 texts on the Index Page under icons and they have proper text

        List<WebElement> textUnderImages = driver.findElements(By.cssSelector("div.benefit-icon+span"));

        softAssert.assertEquals(textUnderImages.size(), 4);

        for (WebElement text : textUnderImages) {
            softAssert.assertTrue(text.isDisplayed());
            softAssert.assertTrue(imagesText.contains(text.getText()), text.getText());
        }

        // 8 Assert that there is the iframe with “Frame Button” exist
        WebElement iframe = driver.findElement(By.cssSelector("iframe"));
        softAssert.assertTrue(iframe.isDisplayed());

        // 9 Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame(iframe);
        softAssert.assertTrue(driver.findElement(By.cssSelector("[id = frame-button]")).isDisplayed());

        // 10 Switch to original window
        driver.switchTo().defaultContent();

        // 11 Assert left section
        List<WebElement> leftElements = driver.findElements(By.cssSelector("ul.sidebar-menu.left>li"));

        softAssert.assertEquals(leftElementsText.size(), 5);

        for (WebElement element : leftElements) {
            softAssert.assertTrue(element.isDisplayed(), "11");
            softAssert.assertTrue(leftElementsText.contains(element.getText()));
        }

        softAssert.assertAll();

    }
    @AfterMethod
    public void afterMethod(){
        // 12 Close Browser
        driver.close();
    }
}