package hw8;

import base.MetalsAndColorsDataProvider;
import entity.MetalsAndColorsData;
import org.testng.annotations.Test;

import static pages.JDIsite.JDISite.*;

public class MetalAndColorsPageTest extends MetalAndColorsPageInit {

    @Test(dataProvider = "metalsAndColorsDataProvider", dataProviderClass = MetalsAndColorsDataProvider.class)
    public void metalAndColorsFormTest(MetalsAndColorsData data) {

        //2 Open Metals & Colors page by Header menu
        chooseHeaderMenu("METALS & COLORS");
        metalAndColorsPage.checkOpened();

        //3 Fill form Metals & Colors by data
        //Submit form Metals & Colors
        metalAndColorsPage.metalsAndColorsForm.fill(data);
        metalAndColorsPage.metalsAndColorsForm.submit();

        //4 Result sections should contains data
        checkResultSectionContainsData(data);
    }
}
