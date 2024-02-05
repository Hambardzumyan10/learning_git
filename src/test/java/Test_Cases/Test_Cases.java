package Test_Cases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.Contuct_us.Functionality_of_the_Contact_Us_page;
import org.example.Homepage_links_validation.Homepage_links_and_navigation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Test_Cases {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void Homepage_links_validation() throws InterruptedException {
        Homepage_links_and_navigation homepage=new Homepage_links_and_navigation(driver);
        homepage.homepage_links_validation();

    }

    @Test
    public void test_Case_1_valid() throws InterruptedException {
        Functionality_of_the_Contact_Us_page contuct_us=new Functionality_of_the_Contact_Us_page(driver);
        contuct_us.valid_contuct_us();

    }
    @Test
    public void test_Case_2_try_empty_fields() throws InterruptedException {
        Functionality_of_the_Contact_Us_page contuct_us=new Functionality_of_the_Contact_Us_page(driver);
        contuct_us.all_field_put_empty();
    }
    @Test
    public void test_Case_3_invalid() throws InterruptedException {
        Functionality_of_the_Contact_Us_page contuct_us=new Functionality_of_the_Contact_Us_page(driver);
        contuct_us.all_fields_valid();
    }


//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }
}
