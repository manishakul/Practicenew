import org.apache.commons.io.FileUtils;
import org.example.Base;
import org.example.Page;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class test {
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

    @Test(groups = {"a"})
    public void addremovelink() {
        page.checkaddremove();
    }
    @Test(groups = "a")
    public void checkwait(){
        page.setDynamicloading();
    }


    @AfterMethod
    public void teardown() {
        driver.close();
        driver.quit();
    }
}
