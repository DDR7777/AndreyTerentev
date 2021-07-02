package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public HomePageFluent() {
        pri
    }

    public void login(String name, String password) {
        profile.click();
        username.sendKeys(name);
        this.password.sendKeys(password);
        submitButton.click();
    }
}
