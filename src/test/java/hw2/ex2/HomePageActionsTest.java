package hw2.ex2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class HomePageActionsTest {
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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // 2 Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page", "Browser title");

        // 3 Perform login
        driver.findElement(By.cssSelector(".profile-photo")).click();

        //new WebDriverWait(driver, 20, 500).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id = 'Name']")));
        driver.findElement(By.cssSelector("[id = 'name']")).sendKeys("Roman");
        driver.findElement(By.cssSelector("[id = 'password']")).sendKeys("Jdi1234");
        driver.findElement(By.cssSelector(".login [type = 'submit']")).click();

        // 4 Assert Username is loggined
        softAssert.assertEquals(driver.findElement(By.cssSelector(".profile-photo [id = user-name]:not([class*='hidden'])")).getText(), "ROMAN IOVLEV", "Username is loggined");

        // 5 Open through the header menu Service -> Different Elements Page
        driver.findElement(By.cssSelector(".uui-navigation.m-l8 a.dropdown-toggle")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[@href='different-elements.html']")).click();

        // 6 Select checkboxes
        driver.findElement(By.xpath("//label[@class='label-checkbox'][contains(normalize-space(), 'Water')]/input")).click();
        driver.findElement(By.xpath("//label[@class='label-checkbox'][contains(normalize-space(), 'Wind')]/input")).click();

        // 7 Select radio
        driver.findElement(By.xpath("//label[@class='label-radio'][contains(normalize-space(), 'Selen')]/input")).click();

        // 8 Select in dropdown
        Select color = new Select(driver.findElement(By.xpath("//select[@class='uui-form-element']")));
        color.selectByVisibleText("Yellow");

        // 9 Select in dropdown
        Assert.assertTrue(driver.findElement(By.xpath("//ul[contains(@class, 'logs')]/li[contains(text(), 'Water') and contains(text(), 'true')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//ul[contains(@class, 'logs')]/li[contains(text(), 'Wind') and contains(text(), 'true')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//ul[contains(@class, 'logs')]/li[contains(text(), 'metal') and contains(text(), 'Selen')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//ul[contains(@class, 'logs')]/li[contains(text(), 'Colors') and contains(text(), 'Yellow')]")).isDisplayed());
    }

    // 10 Close Browser
    @AfterMethod
    public void afterMethod(){
        driver.close();
    }
}
