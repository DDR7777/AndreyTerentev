package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HomePage {
    // 3
    @FindBy(css = ".profile-photo")
    public WebElement profile;
    @FindBy(id = "name")
    public WebElement username;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(css = ".login [type = 'submit']")
    public WebElement submitButton;
    @FindBy(css = ".profile-photo [id = user-name]:not([class*='hidden'])")
    public WebElement fullname;
    // 5
    @FindBy(css = "ul.uui-navigation.nav > li > a")
    public List<WebElement> headerElements;
    // 5-2
    @FindBy(css = ".uui-navigation.m-l8 a.dropdown-toggle")
    public WebElement headerMenuService;
    @FindBy(xpath = "//ul[@class='dropdown-menu']//a[@href='different-elements.html']")
    public WebElement differentElementItem;

    @FindBy(xpath = "//ul[@class='dropdown-menu']//a[@href='user-table.html']")
    public WebElement userTableItem;

    // 6
    @FindBy(css = "span.icons-benefit")
    public List<WebElement> images;
    // 7
    @FindBy(css = "div.benefit-icon+span")
    public List<WebElement> textUnderImages;
    // 8
    @FindBy(css = "iframe")
    public WebElement iframe;
    // 9
    @FindBy(id = "frame-button")
    public WebElement frameButton;
    // 11
    @FindBy(css = "ul.sidebar-menu.left>li")
    public List<WebElement> leftElements;

        private WebDriver driver;

    SoftAssert softAssert = new SoftAssert();

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void login(String name, String password) {
        profile.click();
        username.sendKeys(name);
        this.password.sendKeys(password);
        submitButton.click();
    }

    @Step("Open Home page")
        public void navigate() {
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
    }

    @Step("Open Different Elements Page")
    public void openDifferentElementsPage() {
        headerMenuService.click();
        differentElementItem.click();
    }

    @Step("Open Service menu in Header")
    public void openHeaderMenuService() {
        headerMenuService.click();
    }

    @Step("Open User Table Page")
    public void openUserTablePage(){
        userTableItem.click();
    }


    @Step("Check that Page title is {0}")
    public void checkPageTitle(String expected) {
        Assert.assertEquals(driver.getTitle(), expected, "Browser title");

    }

        @Step("Check that loggined user is {0}")
    public void checkUserIsLoggined(String expected) {
        Assert.assertEquals(fullname.getText(), expected);
    }

    @Step("Check Header elements")
    public void checkHeaderElements(List<String> headerElementsText) {
        softAssert.assertEquals(headerElements.size(), headerElementsText.size(), "4 items on the header section are displayed and they have proper texts");
        for (WebElement element : headerElements) {
            softAssert.assertTrue(element.isDisplayed(), String.format("header element %s is displayed", element.getText()));
            softAssert.assertTrue(headerElementsText.contains(element.getText()), String.format("header element %s is exist", element.getText()));
        }
    }

    @Step("Check images of Index page")
    public void checkImagesOfIndexPage(List<String> imagesText) {
        softAssert.assertEquals(images.size(), imagesText.size(), "4 images on the Index Page and they are displayed");
        for (WebElement image : images) {
            softAssert.assertTrue(image.isDisplayed());
        }
    }

    @Step("Check text under images on Index page")
    public void checkTextUnderImagesOnIndexPage(List<String> underImagesText) {
        softAssert.assertEquals(textUnderImages.size(), underImagesText.size());
        for (WebElement text : textUnderImages) {
            softAssert.assertTrue(text.isDisplayed());
            softAssert.assertTrue(underImagesText.contains(text.getText().trim()), text.getText());
        }
    }

    @Step("Check iframe exists")
    public void checkIFrameExist() {
        softAssert.assertTrue(iframe.isDisplayed());
    }

    @Step("Switch to iframe and check FrameButton in iframe")
    public void checkFrameButtonInIframe() {
        driver.switchTo().frame(iframe);
        softAssert.assertTrue(frameButton.isDisplayed());
        driver.switchTo().defaultContent();
    }

    @Step("Check left elements text on Index page")
    public void checkLeftSectionOnIndexPage(List<String> leftElementsText) {
        softAssert.assertEquals(leftElementsText.size(), leftElements.size());
        for (WebElement element : leftElements) {
            softAssert.assertTrue(leftElementsText.contains(element.getText()));
        }
    }

    public void softAssertAll(){
        softAssert.assertAll();
    }
}
