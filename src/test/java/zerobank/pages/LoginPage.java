package zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import zerobank.utilities.BrowserUtils;
import zerobank.utilities.ConfigurationReader;

public class LoginPage extends BasePage{

    @FindBy(id="signin_button")
    private WebElement signInButton;

    @FindBy(id="user_login")
    private WebElement userName;

    @FindBy(id="user_password")
    private WebElement password;

    @FindBy(name = "submit")
    private WebElement signInSubmit;


    @FindBy(css = "[class='alert alert-error']")
    private WebElement errorMessageElement;

    public void login(){
        String username = ConfigurationReader.getProperty("user_name");
        String password = ConfigurationReader.getProperty("password");

        this.userName.sendKeys(username);
        this.password.sendKeys(password);
        signInSubmit.click();

    }

    public void login(String username, String password){
        this.userName.sendKeys(username);
        this.password.sendKeys(password);
        signInSubmit.click();
    }

    public void signInButtonClick(){
        BrowserUtils.clickWithWait(signInButton);
    }

    public String getErrorMessage(){
        return errorMessageElement.getText();
    }


}
