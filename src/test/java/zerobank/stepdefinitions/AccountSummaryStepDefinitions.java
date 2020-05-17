package zerobank.stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import zerobank.utilities.Pages;

import java.util.List;

public class AccountSummaryStepDefinitions {


    private Pages page = new Pages();


    @Then("user navigates to {string} tab")
    public void user_navigates_to_tab(String tab) {
        page.accountSummaryPage().navigateTo(tab);
    }

    @Then("user verifies that the following account types are displayed")
    public void user_verifies_that_the_following_account_types_are_displayed(List<String> expectedAccountTypes) {
        Assert.assertEquals("List dont match",expectedAccountTypes,page.accountSummaryPage().accountTypes());
    }

    @Then("user verifies that {string} following table columns are displayed")
    public void userVerifiesThatCreditAccountsFollowingTableColumnsAreDisplayed(String table, List<String> expectedTableColumns) {
        if(table.equalsIgnoreCase("Credit Accounts")) {
            List<String> actualTableColumns = page.accountSummaryPage().tableColumns(table);
            Assert.assertEquals("Table columns don't match", expectedTableColumns, actualTableColumns);
        }else if (table.equalsIgnoreCase("Transaction Table")){
            List<String> actualTableColumns = page.accountActivityPage().getTransactionTableHeadersList();
            Assert.assertEquals("Table columns don't match", expectedTableColumns, actualTableColumns);
        }
    }
}
