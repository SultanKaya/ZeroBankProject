package zerobank.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import zerobank.utilities.Driver;
import zerobank.utilities.Pages;

import java.util.List;
import java.util.Map;

public class PayBillsStepDefinitions {


    private Pages page = new Pages();

    @Then("user enters payment amount of {string}")
    public void user_enters_payment_amount_of(String amount) {
        page.payBillsPage().sentKeysAmountInputBox(amount);
    }

    @Then("user enters date of {string}")
    public void user_enters_date_of(String date) {
        page.payBillsPage().sendKeysDateInputBox(date);
    }

    @Then("user verifies that the success message is displayed {string}")
    public void user_verifies_that_the_success_message_is_displayed(String expectedAlertMessage) {
        String actualAlertMessage = page.payBillsPage().getAlertMessage();
        Assert.assertEquals("Alert message is wrong",expectedAlertMessage,actualAlertMessage);
    }

    @Then("user verifies that the error message {string} is displayed on {string} page")
    public void userVerifiesThatTheErrorMessagePleaseFillOutThisFieldMessageIsDisplayedOnPayBillsPage(String expectedErrorMessage,String page) {
        String actualMessage;
        if(page.equalsIgnoreCase("Pay Bills")){
            actualMessage = this.page.payBillsPage().getErrorValidationMessage();
        }else {
            actualMessage = null;
        }
        Assert.assertEquals("Error message is wrong",expectedErrorMessage,actualMessage);

    }

    @Then("user verifies that {string} input box is empty")
    public void userVerifiesThatDateInputBoxIsEmpty(String inputBox) {
        String inputText = page.payBillsPage().getInputBoxText(inputBox);
        Assert.assertTrue(inputText.isEmpty());

    }


    @Then("creates a payee using the following information")
    public void createsAPayeeUsingTheFollowingInformation(Map<String,String> infoTable) {
        page.payBillsPage().newPayeeFormFill(infoTable);
    }

    @Then("message {string} should be displayed")
    public void messageTheNewPayeeTheLawOfficesOfHydePriceSharksWasSuccessfullyCreatedShouldBeDisplayed(String expectedMessage) {
        String actualMessage = page.payBillsPage().addNewPayeeAlertMessage();
        actualMessage =actualMessage.substring(1);
        actualMessage=actualMessage.trim();
        Assert.assertEquals("Messages do not match", expectedMessage,actualMessage);
    }

    @Then("following currencies should be available")
    public void followingCurrenciesShouldBeAvailable(List<String> currencies) {
        List<String> actualCurrencyList = page.payBillsPage().currencyList();

        for(int i=0;i<currencies.size();i++){
            Assert.assertTrue("Currency of " + currencies.get(i)+" was not available",
                    actualCurrencyList.contains(currencies.get(i)));
        }
    }

    @When("user tries to calculate cost without selecting a currency")
    public void userTriesToCalculateCostWithoutSelectingACurrency() {
        page.payBillsPage().clickPurchaseButton();
    }


    @Then("error message is displayed {string}")
    public void errorMessageIsDisplayed(String expectedMessage) {
        String actualMessage = Driver.get().switchTo().alert().getText();
        Driver.get().switchTo().alert().accept();
        Assert.assertEquals("Error message is not shown",expectedMessage,actualMessage);
    }

    @When("user tries to calculate cost without entering a value")
    public void userTriesToCalculateCostWithoutEnteringAValue() {
        page.payBillsPage().selectCurrency("Australia (dollar)");
        page.payBillsPage().clickPurchaseButton();
    }
}
