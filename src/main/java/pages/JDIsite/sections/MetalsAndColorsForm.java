package pages.JDIsite.sections;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import entity.MetalsAndColorsData;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

public class MetalsAndColorsForm extends Form<MetalsAndColorsData> {

    @UI("[name=custom_radio_odd]")
    public RadioButtons oddsSummary;

    @UI("[name=custom_radio_even]")
    public RadioButtons evensSummary;

    @FindBy(css = "#elements-checklist p input")
    private Checklist elements;

    @JDropdown(
            root = ".form-group.colors",
            value = ".filter-option",
            list = "a"
    )
    public Dropdown colors;

    @JDropdown(
            root = ".form-group.metals",
            list = "li",
            expand = ".caret"
    )
    private Dropdown metals;

    @JDropdown(
            root = "#salad-dropdown",
            list = "li",
            value = ".dropdown-toggle"
    )
    private Dropdown vegetables;

    @FindBy(css = "#submit-button")
    private Button submit;

    public MetalsAndColorsForm() {
    }

    //methods
    @Override
    public void fill(MetalsAndColorsData entity) {
        oddsSummary.select(String.valueOf(entity.summary.get(0)));
        evensSummary.select(String.valueOf(entity.summary.get(1)));

        elements.select(entity.elements.toArray(new String[0]));
        colors.select(entity.color);
        metals.select(entity.metals);

        vegetables.select("Vegetables");
        for (String vegetable : entity.vegetables) {
            vegetables.select(vegetable);
        }
    }

    @Step
    public void submit() {
        submit.click();
    }
}
