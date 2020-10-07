package Tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import static java.lang.Thread.sleep;
import PageObjects.loginPage;

public class LoginTest {

    private WebDriver driver;

    @BeforeTest
    public void setUpTest(){
        String currentDirectory = System.getProperty("user.dir");
        System.out.println(currentDirectory);
        String driverPath = currentDirectory.concat("/src/resources/driver/chromedriver_84");
        System.out.println(driverPath);
        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();
    }

    @Test
    public void doLogin() throws InterruptedException{

        loginPage login = new loginPage(driver);

        driver.get("https://demo.opencart.com/index.php?route=account/login");

        login.doLogin("darayaos18@gmail.com", "Test1234");

        Thread.sleep(5000);

        Assert.assertEquals(driver.findElement(By.id("account-account")).isDisplayed(), true);

        Thread.sleep(5000);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
