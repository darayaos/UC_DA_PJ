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

public class LoginTest extends baseTest {

    @Test
    public void doLogin() throws InterruptedException{

        loginPage login = new loginPage(driver, baseURL());
        login.goToPage();
        login.doLogin("darayaos18@gmail.com", "Test1234");
        Thread.sleep(5000);
        Assert.assertEquals(driver.findElement(By.id("account-account")).isDisplayed(), true);
        Thread.sleep(5000);
    }


}
