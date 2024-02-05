package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Commands {
    private WebDriver driver;
    private WebDriverWait webDriverWait;

    // Constructor
    public Commands(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void waitUntilPageIsLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
    // Other methods...

    public void clickWhenClickable(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public void navigate(String url) {
        // Do not create a new ChromeDriver instance here
        driver.get(url);
    }

    public void maximize() {
        driver.manage().window().maximize();
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    private WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public void waitElementToBeVisible(WebElement element) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitElementTobeClickable(WebElement element) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }



    public void click(WebElement element) {
            this.waitElementTobeClickable(element);
            element.click();
    }
    public void hover(WebElement element){
        waitElementToBeVisible(element);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void sendkeys(WebElement element, String keys) {
        this.waitElementToBeVisible(element);
        element.clear();
        element.sendKeys(keys);
    }

    public void scrollPageUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
    }

    public void javaScriptClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
}
