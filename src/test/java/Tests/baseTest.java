package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class baseTest {  //crear funciones globales para poder utilizar en todos los test

    public WebDriver driver;
    public String baseURL()
    {
        return "https://demo.opencart.com/";
    }

    @BeforeTest
    public void setUpTest(){
        String currentDirectory = System.getProperty("user.dir");
        System.out.println(currentDirectory);
        String driverPath = currentDirectory.concat("/src/resources/driver/chromedriver_84");
        System.out.println(driverPath);
        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
