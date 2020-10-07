package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class dashboardPage extends basePage {

    private By accountContainer = By.id("account-account");

    public dashboardPage(WebDriver driver){
        super(driver);
    }
    public WebElement setAccountContainer(){
        return driver.findElement(this.accountContainer);
    }

}
