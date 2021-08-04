package hw5.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import hw5.pages.DifferentElementsPage;
import hw5.pages.HomePage;
import hw5.pages.UserTable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class SiteSteps {


    public String name;
    public String password;
    public String fullname;

    private WebDriver driver = new ChromeDriver();


    private UserTable userTable;
    private HomePage homePage;
    private DifferentElementsPage differentElementsPage;

    public SiteSteps() {
        userTable = new UserTable(driver);
        homePage = new HomePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        readUserProperties();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Step("Open Home page")
    @Given("I open JDI GitHub site")
    public void openHomePage() {
        homePage.navigate();
    }

    @Step("Login with username {0}")
    @And("I login as user \"Roman Iovlev\"")
    public void userLogin() {
        homePage.login(name, password);
    }

    @Step("Check that loggined user is {0}")
    public void checkUserIsLoggined(String expected) {
        homePage.checkUserIsLoggined(expected);
    }

    @Step("Open Different Elements Page")
    @And("I click on \"Different elements\" button in Service dropdown")
    public void openDifferentElementsPage() {
        homePage.openDifferentElementsPage();
    }

    @Step("Select Checkbox with label {0}") //?
    @When("I select '(.+)' checkbox$")
    public void clickCheckbox(String label) {
        differentElementsPage.clickCheckbox(label);
    }

    @And("I select '(.+)' radio$")
    public void clickRadioButton(String label){
        differentElementsPage.clickRadioButton(label);
    }

    @And("I select '(.+)' dropdown$")
    public void selectDropdownItem(String label) {
        differentElementsPage.selectDropdownItem(label);
    }

//    public void checkLogIsDisplayed(String label, String value){
//        differentElementsPage.checkLogIsDisplayed(label, value);
//    }

    @Step("Open Service menu in Header")
    @When("I click on \"Service\" button in Header")
    public void openServiceMenuInHeader() {
        homePage.openHeaderMenuService();
    }

    @Step("Open User Table Page")
    @And("I click on \"User Table\" button in Service dropdown")
    public void openTablePage() {
        homePage.openUserTablePage();
    }

    @Step("User Table page should be opened")
    @Then("\"(.+)\" page should be opened$")
    public void checkPageTitle(String checkTitle) {
        homePage.checkPageTitle(checkTitle);
    }

    @Step
    @And("(\\d+) (Number Type Dropdowns|Usernames|Description texts under images|checkboxes) should be displayed on Users Table on User Table Page$")
    public void checkUsersTable(int expQty, String elementType) {
        userTable.checkElementsAreDisplayed(expQty, elementType);
    }

    @Step
    @And("User table should contain following values:")
    public void userTableContainsValues(@Transpose DataTable arg) {
        userTable.checkUserTableValues(arg);
    }

    @Step
    @And("droplist should contain values in column Type for user Roman")
    public void droplistContainValues(List<String> expOptions) {
        userTable.checkDroplistOptions(expOptions);
    }

    @Step
    @When("I select 'vip' checkbox for \"(.+)\"$")
    public void selectVipCheckbox(String name) {
        userTable.selectVipCheckbox(name);
    }

    @Step
    @Then("(\\d+) log row has \"(.+): (condition|value) changed to (.+)\" text in log section$")
    public void logRowHasText(int number, String label, String condition, String value) {
        userTable.checkLogIsDisplayed(number, label, value);
    }

    @After
    public void closeDriver() {
        driver.close();
    }

    private void readUserProperties() {
        try (InputStream inputStream = new FileInputStream("src/main/resources/user.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            name = properties.getProperty("user");
            password = properties.getProperty("password");
            fullname = properties.getProperty("fullname");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
