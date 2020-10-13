package Tests;

import org.testng.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import PageObjects.loginPage;
import PageObjects.dashboardPage;
import utilities.waits;

import DataProvider.userDataProvider;
import pojo.loginData;

public class LoginTest extends baseTest {

    LoginTest()
    {
        super("chrome");
    }

    @Test(groups = {"sanity"}, dataProvider = "getUsersDataFromJson", dataProviderClass = userDataProvider.class)
    public void doLogin(loginData _loginData) throws InterruptedException{

        loginPage login = new loginPage(driver, baseURL());
        waits wait = new waits(driver);
        dashboardPage dashboard = new dashboardPage(driver);
        login.goToPage();
        login.doLogin(_loginData.getEmail(), _loginData.getPassword());
        wait.UntilElementExists(dashboard.setAccountContainer());
        Assert.assertEquals(dashboard.setAccountContainer().isDisplayed(), true);
    }

}
