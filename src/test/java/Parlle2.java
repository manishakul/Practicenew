import org.apache.commons.io.FileUtils;
import org.example.Base;
import org.example.Page;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Parlle2 {
    Base base = new Base();
    Page page;
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        try {
            FileUtils.cleanDirectory(new File("screenshot"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driver = base.init();
        page = new Page(driver);
        driver.get("https:the-internet.herokuapp.com");
    }

    @Test
    public void addremovelink() {
        page.checkaddremove();
    }



    @AfterMethod
    public void teardown() {
        driver.close();
        driver.quit();
    }
}
