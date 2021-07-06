package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class DifferentElementsPage {
    // 6-2
    @FindBy(xpath = "//label[@class='label-checkbox']")
    private List<WebElement> checkboxes;

    // 7-2
    @FindBy(xpath = "//label[@class='label-radio']")
    private List<WebElement> radioButtons;

    // 8-2
    @FindBy(xpath = "//select[@class='uui-form-element']")
    private WebElement dropdown;

    // 9-2
    @FindBy(xpath = "//ul[contains(@class, 'logs')]/li")
    private List<WebElement> logs;

    private WebDriver driver;

    /*
    public WebElement getCheckbox(String label){
        for (WebElement checkbox : checkboxes) {
           if (checkbox.getText().trim().equals(label)) {
            return checkbox.findElement(By.cssSelector("input"));
            }
        }
        return null;
    }

    public WebElement getRadioButton(String label){
        for (WebElement radioButton : radioButtons) {
            if (radioButton.getText().trim().equals(label)) {
                return radioButton.findElement(By.cssSelector("input"));
            }
        }
        return null;
    }

    public void selectDropdownItem(String label) {
        Select color = new Select(dropdown);
        color.selectByVisibleText(label);
    }

    public WebElement getLog(String label, String value){
        for (WebElement log : logs) {
            String logText = log.getText();
            if (logText.contains(label)&&logText.contains(value)) {
                return log;
            }
        }
        return null;
    }
    */

    public DifferentElementsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Select Checkbox with label {0}")
    public void clickCheckbox(String label) {
        for (WebElement checkbox : checkboxes) {
            if (checkbox.getText().trim().equals(label)) {
                checkbox.findElement(By.cssSelector("input")).click();
                break;
            }
        }
    }

    @Step("Select Radio button ")
    public void clickRadioButton(String label) {
        for (WebElement radioButton : radioButtons) {
            if (radioButton.getText().trim().equals(label)) {
                radioButton.findElement(By.cssSelector("input")).click();
                break;
            }
        }
    }

    @Step
    public void selectDropdownItem(String label) {
        Select color = new Select(dropdown);
        color.selectByVisibleText(label);
    }


    private boolean isLogDisplayed(String label, String value) {
        for (WebElement log : logs) {
            String logText = log.getText();
            if (logText.contains(label) && logText.contains(value)) {
                return true;
            }
        }
        return false;
    }

    @Step("Check Log with label {0} and value {1} is displayed")
    public void checkLogIsDisplayed(String label, String value){
        Assert.assertTrue(isLogDisplayed(label, value));
    }
}