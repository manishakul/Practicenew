package org.example;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.openqa.selenium.OutputType.FILE;

public class Base {
    private static WebDriver driver;
    public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();


    public static WebDriver init() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        threadLocal.set(driver);
        return getDriver();

    }

    public static WebDriver getDriver() {
        return threadLocal.get();
    }

    public static void scroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)");
    }

    public  static void screenshot() {
        try {

            File file = ((TakesScreenshot) driver).getScreenshotAs(FILE);
            FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void waiting(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}

