package org.example.Contuct_us;

import org.example.Commands;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Functionality_of_the_Contact_Us_page {

    @FindBy(xpath = "//input[@placeholder='First Name*']")
    private WebElement first_name;

    @FindBy(css = "input[placeholder='Last Name*']")
    private WebElement last_name;

    @FindBy(css = "input[placeholder='Business Email*']")
    private WebElement business_email;

    @FindBy(css = "input[placeholder='Company Name*']")
    private WebElement company_name;

    @FindBy(xpath = "//input[@id=':R9b4m:']")
    private WebElement phone_number;

    @FindBy(css = ".form-select")
    private WebElement form;

    @FindBy(css = "option[value='Sales Question']")
    private WebElement sales_question;

    @FindBy(css = "textarea[placeholder='How can we help you?']")
    private WebElement message_write;

    @FindBy(css = ".far.fa-chevron-right.ps-3")
    private WebElement submit_button;


    private WebDriver driver;
    private Commands commands;


    public Functionality_of_the_Contact_Us_page(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.commands = new Commands(driver);
        Thread.sleep(400);
    }

    public void all_field_put_empty() throws InterruptedException {
        commands = new Commands(driver);
        driver.get("https://webz.io/tte/contact-us");
        commands.maximize();
        commands.click(submit_button);
        Thread.sleep(1000);
        int validationtexts = driver.findElements(By.cssSelector(".text-danger")).size();
        System.out.println("all fields is required -- " + validationtexts);
    }
    public void all_fields_valid() throws InterruptedException {
        commands = new Commands(driver);
        driver.get("https://webz.io/tte/contact-us");
        commands.click(submit_button);
        Thread.sleep(1000);
        commands.maximize();
        commands.sendkeys(first_name, "QA Candidate");
        commands.click(submit_button);
        commands.sendkeys(last_name, "Test");
        commands.click(submit_button);
        commands.sendkeys(business_email, "test@Test.com");
        commands.click(submit_button);
        commands.sendkeys(company_name, "TestOrg");
        commands.click(submit_button);
        commands.sendkeys(phone_number, "77734648");
        commands.click(form);
        commands.click(sales_question);
        commands.sendkeys(message_write, "Testing");
        commands.click(submit_button);
        if (driver.findElements(By.cssSelector(".error-accured")).size() > 0) {
            System.out.println("can not logged in -- " + driver.findElement(By.cssSelector(".text-danger")).getText());
        } else {
            System.out.println("succseefully loged");
        }
    }

    public void valid_contuct_us() throws InterruptedException {
        commands = new Commands(driver);
        driver.get("https://webz.io/tte/contact-us");
        commands.maximize();
        commands.sendkeys(first_name, "QA Candidate");
        commands.sendkeys(last_name, "Test");
        commands.sendkeys(business_email, "test@Test.com");
        commands.sendkeys(company_name, "TestOrg");
        commands.sendkeys(phone_number, "77734648");
        commands.click(form);
        commands.click(sales_question);
        commands.sendkeys(message_write, "Testing");
        commands.click(submit_button);
        Thread.sleep(1550);
        if (driver.findElements(By.cssSelector(".error-accured")).size() > 0) {
            System.out.println("can not logged in -- " + driver.findElement(By.cssSelector(".text-danger")).getText());
        } else {
            System.out.println("succseefully loged");
        }

    }


}