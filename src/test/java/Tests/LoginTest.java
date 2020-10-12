package Tests;

import org.testng.*;
import org.testng.annotations.Test;
import PageObjects.loginPage;
import PageObjects.dashboardPage;
import utilities.waits;


public class LoginTest extends baseTest {

    LoginTest()
    {
        super("chrome");
    }

    @Test
    public void doLogin() throws InterruptedException{

        loginPage login = new loginPage(driver, baseURL());
        waits wait = new waits(driver);
        dashboardPage dashboard = new dashboardPage(driver);
        login.goToPage();
        login.doLogin("darayaos18@gmail.com", "Test1234");
        wait.UntilElementExists(dashboard.setAccountContainer());
        Assert.assertEquals(dashboard.setAccountContainer().isDisplayed(), true);
    }


}
