package zerobank.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import zerobank.utilities.Pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccountActivityStepDefinitions {

    private Pages page = new Pages();

    @Then("user verifies that the following {string} dropdown options are available")
    public void user_verifies_that_the_following_account_dropdown_options_are_available(String dropdown, List<String> expectedOptions) {
        if(dropdown.equalsIgnoreCase("account")){
            List <String> actualOptions = page.accountActivityPage().getListOfDropDownOptions();
            Assert.assertEquals("Options do not match", expectedOptions,actualOptions);
        }

    }

    @Then("user verifies that the default drop down option is {string}")
    public void userVerifiesThatTheDefaultDropDownOptionIsSavings(String expectedOption) {
        String actualOption =page.accountActivityPage().getDefaultDropDownOption();
        Assert.assertEquals("Default options do not match",expectedOption,actualOption);
    }

    @When("user clicks on {string} link on the Account Summary Page")
    public void userClicksOnLinkLinkOnTheAccountSummaryPage(String link) {
        page.accountSummaryPage().clickAccountTypeLink(link);
    }

    @And("Account drop drown should have {string} selected")
    public void accountDropDrownShouldHaveOptionSelected(String expectedOption) {
        String actualOption= page.accountActivityPage().getDefaultDropDownOption();
        Assert.assertEquals("Wrong default option is displayed",expectedOption,actualOption);
    }

    @When("user enters date range from {string} to {string}")
    public void userEntersDateRangeFromTo(String fromDate, String toDate) {
        page.accountActivityPage().sendKeysToTransactionDateRange(fromDate,toDate);
    }

    @And("the results should be sorted by date")
    public void theResultsShouldBeSortedByDate() {
        List<String> originalList = page.accountActivityPage().getDatesList();
        List<String> copy = List.copyOf(originalList);

        Collections.sort(originalList);
        Collections.reverse(originalList);

        Assert.assertEquals("Dates are not sorted",originalList,copy);
    }

    @And("the results table should not contain transactions date {string}")
    public void theResultsTableShouldNotContainTransactionsDate(String date) {
        List<String> dates = page.accountActivityPage().getDatesList();
        Assert.assertFalse("The date is contained in the list", dates.contains(date));
    }

    @Then("results table should only show transactions from {string} to {string}")
    public void resultsTableShouldOnlyShowTransactionsFromTo(String fromDate, String toDate) {
        List<String> dates = page.accountActivityPage().getDatesList();
        boolean check = false;
        int fromLastDigit =Integer.parseInt(fromDate.replace("2012-09-0",""));
        int toLastDigit = Integer.parseInt(toDate.replace("2012-09-0",""));
        for(String each: dates){
            int tempDigit =Integer.parseInt(each.replace("2012-09-0",""));
            if(tempDigit >= fromLastDigit && tempDigit <= toLastDigit ){
                check =true;
            }
        }


        Assert.assertTrue("Displayed date range is wrong",check);
//        Collections.sort(dates);
//        System.out.println("dates get(0) :" +dates.get(0) + " and fromDate " + fromDate);
//        boolean startCheck = dates.get(0).equalsIgnoreCase(fromDate);
//        boolean endCheck = dates.get(dates.size()-1).equalsIgnoreCase(toDate);
//        Assert.assertTrue("Start date is wrong",startCheck);
//        Assert.assertTrue("end date is wrong", endCheck);
    }

    @Then("user enter description {string}")
    public void userEnterDescriptionONLINE(String description) {
        page.accountActivityPage().sendKeysToTranDescription(description);
    }

    @Then("results table should show descriptions containing {string}")
    public void resultsTableShouldShowDescriptionsContainingONLINE(String descriptionPiece) {
        List<String> descriptions = page.accountActivityPage().getDescriptionList();

        for(String each: descriptions){
            Assert.assertTrue("Description does not involve key word", each.contains(descriptionPiece));
        }
    }

    @And("the results table should not show description containing {string}")
    public void theResultsTableShouldNotShowDescriptionContainingONLINE(String wrongPiece) {
        List<String> descriptions = page.accountActivityPage().getDescriptionList();

        for(String each: descriptions){
            Assert.assertFalse("Wrong description is shown",each.contains( wrongPiece));
        }
    }

    @Then("results table should show at least one result under {string}")
    public void resultsTableShouldShowAtLeastOneResultUnderDeposit(String header) {
        List<String> results = new ArrayList<>();

        if(header.equalsIgnoreCase("Deposit")){
            results = page.accountActivityPage().getDepositsList();
        }else if(header.equalsIgnoreCase("Withdrawal")){
            results = page.accountActivityPage().getWithdrawalsList();
        }
        Assert.assertTrue("There is no results displayed under " + header, results.size()>0);
    }

    @When("user selects type {string}")
    public void userSelectsTypeDeposit(String option) {
        page.accountActivityPage().selectTypeDropDownOption(option);
    }

    @But("the results table should show no result under {string}")
    public void theResultsTableShouldShowNoResultUnderDeposit(String header) {
        List<String> results = new ArrayList<>();

        if(header.equalsIgnoreCase("Deposit")){
            results = page.accountActivityPage().getDepositsList();
        }else if(header.equalsIgnoreCase("Withdrawal")){
            results = page.accountActivityPage().getWithdrawalsList();
        }
        Assert.assertFalse("There is results displayed under " + header + " when non were expected", results.size()>0);
    }




}
