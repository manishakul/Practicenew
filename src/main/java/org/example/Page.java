package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Page {
     WebDriver driver;

    @FindBy(linkText = "A/B Testing")
    WebElement abtestl;
    @FindBy(xpath = "//div[@class='example']/h3")
    WebElement headingabttest;
    @FindBy(xpath = "//div[@id='content']/ul/li[2]/a")
    WebElement addRemove;
    @FindBy(xpath = "//div[@class='example']/button")
    WebElement AddElement;
    @FindBy(xpath = "//div[@class='example']/div/button")
    WebElement DeletElement;
    @FindBy(linkText = "Basic Auth")
    WebElement basicAuth;
    @FindBy(linkText = " Digest Authentication")
    WebElement DigestAuthentication;
    @FindBy(linkText = "Checkboxes")
    WebElement checkboxes;

    @FindBy(xpath = "//input[@type='checkbox'][1]")
    WebElement checkbox1;
    @FindBy(xpath = "//input[@type='checkbox'][2]")
    WebElement checkbox2;
    @FindBy(linkText = "Dropdown")
    WebElement dropdown;
    @FindBy(id = "dropdown")
    WebElement dropd;
    @FindBy(linkText = "Drag and Drop")
    WebElement dragndrop;
    @FindBy(id = "column-a")
    WebElement columna;
    @FindBy(id = "column-b")
    WebElement columnb;
    @FindBy(linkText = "Infinite Scroll")
    WebElement scrollpage;
    @FindBy(linkText = "Multiple Windows")
    WebElement multiwind;
    @FindBy(xpath = "//div[@id='content']/div/a")
    WebElement clickhere;
    @FindBy(xpath = "//div[@id='content']/div/h3")
    WebElement multiwindhead;
    @FindBy(linkText = "Floating Menu")
    WebElement floatmenu;
    @FindBy(xpath = "//div[@id='menu']/ul/li[1]/a")
    WebElement menuitem1;
    @FindBy(xpath = "//div[@id='menu']/ul/li[2]/a")
    WebElement menuitem2;
    @FindBy(linkText = "File Upload")
    WebElement fileupload;
    @FindBy(xpath = "//input[@id='file-upload']")
    WebElement choosefile;
    @FindBy(xpath = "//input[@id='file-submit']")
    WebElement submitfile;
    @FindBy(linkText = "Frames")
    WebElement frame;
    @FindBy(linkText = "Entry Ad")
    WebElement adpopup;
    @FindBy(xpath = "//div[@class='modal-footer']/p")
    WebElement close;
    @FindBy(linkText = "JavaScript Alerts")
    WebElement allert;
    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    WebElement firstalert;
    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    WebElement secondalert;
    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    WebElement thirdalert;
    @FindBy(linkText = "Dynamic Loading")
    WebElement dynamicloading;
    @FindBy(linkText = "Example 1: Element on page that is hidden")
    WebElement firstelement;
    @FindBy(xpath = "//div[@id='start']/button")
    WebElement start;
    @FindBy(xpath = "//div[@id='finish']/h4")
    WebElement hello;


    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkaddremove(){
        addRemove.click();
       // Base.screenshot();
        AddElement.click();
        Assert.assertTrue(DeletElement.isDisplayed());
        if(DeletElement.isDisplayed()){
            DeletElement.click();
        }
    }
    public void setDynamicloading(){
        dynamicloading.click();
        firstelement.click();
        Base.waiting();
        start.click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(hello));
        System.out.println(hello.getText());
    }
    public  void windows(){
        multiwind.click();
        clickhere.click();
        String s=driver.getWindowHandle();
        Set<String> ss=driver.getWindowHandles();
        Iterator<String>it=ss.iterator();
        driver.switchTo().window(it.next());
        }}