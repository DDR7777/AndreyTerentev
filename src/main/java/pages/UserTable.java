package pages;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Transpose;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class UserTable {
    @FindBy(css = "#user-table > tbody > tr > td:nth-child(1)")
    private List<WebElement> numberColumn;

    @FindBy(css = "#user-table > tbody > tr > td:nth-child(2) > select")
    private List<WebElement> typeColumn;

    @FindBy(css = "#user-table > tbody > tr > td:nth-child(3)")
    private List<WebElement> nameColumn;

    @FindBy(css = "#user-table > tbody > tr > td:nth-child(4) > img")
    private List<WebElement> imageColumn;

    @FindBy(css = "#user-table > tbody > tr > td:nth-child(4) span")
    private List<WebElement> descriptionColumn;

    @FindBy(css = "#user-table > tbody > tr > td:nth-child(4) input")
    private List<WebElement> checkboxesColumn;

    @FindBy(css = "#user-table tr")
    private List<WebElement> rows;

    @FindBy(xpath = "//ul[contains(@class, 'logs')]/li")
    private List<WebElement> logs;


    private WebDriver driver;

    public UserTable(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public void selectVipCheckbox(String name) {
        for (int i = 1; i < rows.size(); i++) {
            WebElement element = rows.get(i);
            if (element.findElement(By.cssSelector("a")).getText().equals("Sergey Ivan")) {
                element.findElement(By.cssSelector("td:nth-child(4) input")).click();
            }
        }
    }


    public void checkElementsAreDisplayed(int expQty, String elementType) {
        List<WebElement> elements;
        switch (elementType) {
            case "Number Type Dropdowns":
                elements = typeColumn;
                break;
            case "Usernames":
                elements = nameColumn;
                break;

            case "Description texts under images":
                elements = descriptionColumn;
                break;
            case "checkboxes":
                elements = checkboxesColumn;
                break;
            default:
                throw new RuntimeException("Unexpected element type");
        }
        Assert.assertEquals(elements.size(), expQty);
        for (WebElement element : elements) {
            Assert.assertTrue(element.isDisplayed());
        }
    }


    public void checkUserTableValues(@Transpose DataTable arg) {
        List<List<String>> table = arg.cells();
        List<String> numberColumnValue = new ArrayList<>();
        List<String> nameColumnValue = new ArrayList<>();
        List<String> descriptionColumnValue = new ArrayList<>();

        for (WebElement element : numberColumn) {
            numberColumnValue.add(element.getText());
        }
        Assert.assertEquals(numberColumnValue, table.get(0).subList(1, arg.width()));

        for (WebElement element : nameColumn) {
            nameColumnValue.add(element.getText());
        }
        Assert.assertEquals(nameColumnValue, table.get(1).subList(1, arg.width()));

        for (WebElement element : descriptionColumn) {

            descriptionColumnValue.add(element.getText().replace("\n", " "));
        }
        Assert.assertEquals(descriptionColumnValue, table.get(2).subList(1, arg.width()));//shouldHave(texts(table.get(0).subList(1, arg.width())));
    }


    public void checkDroplistOptions(List<String> expOptions) {

        List<String> nameColumnValue = new ArrayList<>();
        List<WebElement> dropdownOptions = typeColumn.get(0).findElements(By.cssSelector("option"));

        for (WebElement element : dropdownOptions) {
            nameColumnValue.add(element.getText());
        }
        Assert.assertEquals(nameColumnValue, expOptions.subList(1, expOptions.size()));

    }

    private int isLogDisplayed(String label, String value) {
        int number = 0;
        for (WebElement log : logs) {
            String logText = log.getText();
            if (logText.contains(label) && logText.contains(value)) {
                number++;
            }
        }
        return number;
    }


    public void checkLogIsDisplayed(int number, String label, String value) {
        Assert.assertEquals(isLogDisplayed(label, value), number);
    }
}


