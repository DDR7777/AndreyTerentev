package pages.JDIsite.sections;

import com.epam.jdi.light.elements.complex.DataList;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.ui.html.elements.common.Text;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultSection extends Section {

    @FindBy(css = ".results li")
    public List<Text> results;
}
