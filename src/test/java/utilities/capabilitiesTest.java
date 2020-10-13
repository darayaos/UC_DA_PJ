package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;

import java.util.concurrent.TimeUnit;

public class capabilitiesTest {

    private WebDriver driver;
    public ChromeOptions options;

    //@Test
    public void argumentsTest() {
        System.setProperty("webdriver.chrome.driver", "src/resources/driver/chromedriver_84");

        options = new ChromeOptions();
        options.addArguments("--kiosk");
        options.addArguments("screenshot");
        options.addArguments("--headless");
        options.addArguments("--window-size=800,800");
        options.addArguments("--incognito");


        driver = new ChromeDriver(options);

        driver.get("https://demo.opencart.com/index.php?route=account/login");

    }

    // @Test
    public void implicitWait() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.id("downloadButton")).click();
        // driver.get("https://demo.opencart.com/index.php?route=account/login");
        driver.close();
    }

    // @Test
    public void explicitWait(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.get("https://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html");
        driver.findElement(By.id("downloadButton")).click();
        wait.until(ExpectedConditions.textToBe(By.className("progress-label"),"Complete"));
    }

    // @Test
    public void dragAndDropTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://www.w3schools.com/html/html5_draganddrop.asp");

        Actions builder = new Actions(driver);
        WebElement elementFrom = driver.findElement(By.xpath("//img[@id='drag1']"));
        WebElement elementTo = driver.findElement(By.id("div2"));
        // WebElement release = driver.findElement(By.xpath("//div[@id='droppedlist']"));
        //actions.dragAndDrop(elementFrom,elementTo);
      /* Action dragAndDrop = builder.clickAndHold(elementFrom)
                .release(elementTo)
                .build(); */
        Action dragAndDrop = builder.dragAndDrop(elementFrom,elementTo).build();
        dragAndDrop.perform();


        driver.close();
    }

    //  @Test
    public void moveToElement() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");

        Actions builder = new Actions(driver);
        WebElement elementFrom = driver.findElement(By.xpath("//div[@id='todrag']/span[1]"));
        Action holdMouse =  builder.moveToElement(elementFrom).build();
        holdMouse.perform();

    }



}