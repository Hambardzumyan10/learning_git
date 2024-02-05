package org.example.Homepage_links_validation;

import org.example.Commands;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Homepage_links_and_navigation {
    @FindBy(css = ".title")
    private WebElement products;


    private WebDriver driver;
    private Commands commands;

    public void navigateTo() {
        commands.navigate("https://webz.io/");
        commands.maximize();
    }

    public Homepage_links_and_navigation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        this.commands = new Commands(driver);
    }



    public void homepage_links_validation() throws InterruptedException {
        navigateTo();
        commands = new Commands(driver);
        commands.hover(products);
        Thread.sleep(700);

        List<WebElement> sections = driver.findElements(By.cssSelector(".buttom-nav.show>.row>.col-4.px-4"));

        for (int i = 0; i < sections.size(); i++) {
            commands.hover(products);
            Thread.sleep(700);
            sections = driver.findElements(By.cssSelector(".buttom-nav.show>.row>.col-4.px-4"));
            int href_size = sections.get(i).findElements(By.cssSelector(".sub-title")).size();

            for (int a = 0; a < href_size; a++) {
                commands.hover(products);
                Thread.sleep(700);
                sections = driver.findElements(By.cssSelector(".buttom-nav.show>.row>.col-4.px-4"));
                WebElement sub_title = sections.get(i).findElements(By.cssSelector(".sub-title")).get(a);

                String sub_title_name = sub_title.getText();
                String sub_title_href_link = sub_title.findElement(By.cssSelector("a")).getAttribute("href");
                commands.javaScriptClick(sub_title.findElement(By.cssSelector("a")));
                Thread.sleep(500);

                try {
                    if (driver.findElement(By.cssSelector("body")).isDisplayed()) {
                        System.out.println(" Link is OK -- " + sub_title_name + " -- " + sub_title_href_link);
                    }
                }catch (Throwable something_error){
                    System.out.println(" Error -- " + sub_title_name + " -- " + sub_title_href_link);
                }
                Thread.sleep(500);
                driver.get("https://webz.io/");
                Thread.sleep(4000);
            }
        }
    }





}

