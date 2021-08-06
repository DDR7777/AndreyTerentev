package pages.JDIsite.sections;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import entity.User;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends Form<User> {
    @FindBy(id = "name")
    public TextField name;

    @FindBy(id = "password")
    public TextField password;

    @FindBy(css = ".login [type = 'submit']")
    public Button enter;

}
