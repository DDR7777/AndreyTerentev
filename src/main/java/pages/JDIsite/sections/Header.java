package pages.JDIsite.sections;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

public class Header extends Section {

    @FindBy(css = ".uui-navigation.m-l8")
    public Menu headerMenu;

}
