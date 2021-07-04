package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePageFluent {
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

    public HomePageFluent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePageFluent navigate() {
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        return this;
    }

    public HomePageFluent login(String name, String password) {
        profile.click();
        username.sendKeys(name);
        this.password.sendKeys(password);
        submitButton.click();
        return this;
    }

    public DifferentElementsPageFluent openDifferentElementsPage() {
        headerMenuService.click();
        differentElementItem.click();
        return new DifferentElementsPageFluent(driver);
    }
}

