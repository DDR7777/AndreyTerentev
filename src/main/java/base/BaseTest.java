package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest {
    public String name;
    public String password;
    public String fullname;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
        readUserProperties();
    }

    private void readUserProperties(){
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
