package zerobank.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import zerobank.utilities.ConfigurationReader;
import zerobank.utilities.Driver;
import zerobank.utilities.Pages;

public class LoginStepDefinitions {

    private Pages page = new Pages();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.getProperty("url"));
    }

    @Then("user clicks on {string} button")
    public void user_clicks_on_button(String button) {
        if(button.equalsIgnoreCase("Sign in")){
            page.loginPage().signInButtonClick();
        }else if(button.equalsIgnoreCase("Pay")){
            page.payBillsPage().clickPayButton();
        }else if (button.equalsIgnoreCase("Find Transaction")){
            page.accountActivityPage().clickOnFindTransactionTab();
        }else if(button.equalsIgnoreCase("transaction find")){
            page.accountActivityPage().clickOnFindButton();
        }else if(button.equalsIgnoreCase("Add New Payee")){
            page.payBillsPage().clickAddNewPayee();
        }else if (button.equalsIgnoreCase("Purchase Foreign Currency")){
            page.payBillsPage().clickPurchaseForeignCurrencyTab();

        }else{
            System.out.println("Invalid Button");
        }
    }

    @Then("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        page.loginPage().login(username,password);
    }

    @Then("user verifies that the page title is {string}")
    public void user_verifies_that_the_page_title_is(String expectedTitle) {
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Wrong page title", expectedTitle,actualTitle);
    }

    @Then("user verifies that the error message {string} is displayed")
    public void user_verifies_that_the_error_message_is_displayed(String expectedErrorMessage) {
        String actualErrorMessage = page.loginPage().getErrorMessage();
        Assert.assertEquals("Error message is not displayed",expectedErrorMessage,actualErrorMessage);
    }

    @And("user logs in as {string}")
    public void userLogsInAsUsername(String username) {
        System.out.println("Logging in as " + username);
        page.loginPage().login();
    }


}
