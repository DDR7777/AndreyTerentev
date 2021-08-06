package pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import pages.JDIsite.sections.MetalsAndColorsForm;

@Url("/metals-colors.html")
@Title("Metal and Colors")
public class MetalAndColorsPage extends WebPage {

    public MetalsAndColorsForm metalsAndColorsForm;
}
