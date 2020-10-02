import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import static java.lang.Thread.sleep;

public class LoginTest {

    private WebDriver driver;
    @Test
    public void doLogin() throws InterruptedException{
        System.out.println("Testing");
        String currentDirectory = System.getProperty("user.dir");
        System.out.println(currentDirectory);
        String driverPath = currentDirectory.concat("/src/resources/driver/chromedriver_84");
        System.out.println(driverPath);
        System.setProperty("webdriver.chrome.driver",driverPath);

        driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/index.php?route=account/login");
        driver.findElement(By.id("input-email")).sendKeys("darayaos18@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("Test1234");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        Assert.assertEquals(driver.findElement(By.id("account-account")).isDisplayed(), true);

        Thread.sleep(5);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
