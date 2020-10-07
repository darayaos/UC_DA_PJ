package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage extends basePage {

    private By emailTextBox = By.id("input-email");
    private By passwordTextBox = By.id("input-password");
    private By loginButton = By.xpath("//input[@value='Login']");

    public loginPage(WebDriver driver){
        super(driver); //una instancia de la clase que se esta extendiendo extends basepage
    }

// todos los elementos se declaran publicos, asi el usuario es capaz de poder utilizar todos estos elementos en muchas clases/testcases distintos

    public WebElement setEmailTextBox() {
        return driver.findElement(this.emailTextBox);
    }

    public WebElement setPasswordTextBox(){
        return driver.findElement(this.passwordTextBox);
    }

    public WebElement setLoginButton(){
        return driver.findElement(this.loginButton);
    }

    public void doLogin(String email, String password) {
        this.setEmailTextBox().sendKeys(email);
        this.setPasswordTextBox().sendKeys(password);
        this.setLoginButton().click();


    }
}
