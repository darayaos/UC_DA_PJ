package Tests;

import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
//utilizamos el los binarios del webdriver

public class baseTest {  //crear funciones globales para poder utilizar en todos los test

    public WebDriver driver;
    private String browser;
    public ChromeOptions  chromeOptions; //capabilities

    public baseTest(String browser)
    {
        this.browser = browser;
    }

    public String baseURL()
    {
        return "https://demo.opencart.com/";
    }

    @BeforeMethod(alwaysRun = true)
    public void setUpTest(){
        chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless"); lo ejecutamos headless
        chromeOptions.addArguments("--window-size=1920,1080");
        // solamente funciona con --kiosk pero este me abre full screen
        this.setWebDriverConfiguration(browser, chromeOptions);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    private void setWebDriverConfiguration(String browser, ChromeOptions options){
        if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(options);
        }else{
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }


    }

}
