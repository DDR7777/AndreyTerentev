package base;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class AllureAttachmentListener extends TestListenerAdapter {
    @Attachment(value = "Attachment: {0}", type = "image/png")
    public byte[] makeScreenshot(WebDriver driver) {
        byte[] array = {1};
        try {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        return array;
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("*******************************************************************************");
        System.out.println("*******************************************************************************");
        System.out.println("*******************************************************************************");
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).driver;
        if(driver instanceof WebDriver) {
            makeScreenshot(driver);}}
//    @Override
//    public void onTestSuccess(ITestResult tr) {
//        makeScreenshot();
//    }
}
