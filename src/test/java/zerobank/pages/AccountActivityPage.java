package zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import zerobank.utilities.BrowserUtils;

import java.util.ArrayList;
import java.util.List;

public class AccountActivityPage extends BasePage {

    @FindBy(id = "aa_accountId")
    private WebElement accountDropdown;

    @FindBy(css = "#all_transactions_for_account th")
    private List<WebElement> transactionTableHeaders;

    @FindBy(linkText = "Find Transactions")
    private WebElement findTransactionTab;

    @FindBy(id = "aa_description")
    private WebElement transactionDescriptionInput;

    @FindBy(id = "aa_fromDate")
    private WebElement transactionFromDateInput;

    @FindBy(id = "aa_toDate")
    private WebElement transactionToDateInput;

    @FindBy(id = "aa_type")
    private WebElement transactionTypeDropDown;

    @FindBy(css = "[type='submit']")
    private WebElement findButton;

    @FindBy(css = "td:first-child")
    private List<WebElement> displayedDateElements;

    @FindBy(xpath = "//tbody/tr/td[2]")
    private List<WebElement> displayedDescriptionElement;

    @FindBy(xpath = "//tbody/tr/td[3]")
    private List<WebElement> displayedDepositElements;

    @FindBy(xpath = "//tbody/tr/td[4]")
    private List <WebElement> displayedWithdrawalElements;



    public String getDefaultDropDownOption() {
        Select select = new Select(accountDropdown);
        return select.getFirstSelectedOption().getText();
    }

    public void setDropDownOption(String option) {
        Select select = new Select(accountDropdown);
        select.selectByVisibleText(option);

    }

    public List<String> getListOfDropDownOptions() {
        Select select = new Select(accountDropdown);
        return BrowserUtils.getListOfString(select.getOptions());
    }

    public List<String> getTransactionTableHeadersList() {
        return BrowserUtils.getListOfString(transactionTableHeaders);
    }

    public void clickOnFindTransactionTab() {
        BrowserUtils.clickWithWait(findTransactionTab);
    }

    public void sendKeysToTranDescription(String description) {
        BrowserUtils.waitForVisibility(transactionDescriptionInput, 5);
        transactionDescriptionInput.clear();
        transactionDescriptionInput.sendKeys(description);
    }

    public void sendKeysToTransactionDateRange(String fromDate, String toDate) {
        BrowserUtils.waitForVisibility(transactionFromDateInput, 5);
        BrowserUtils.waitForVisibility(transactionToDateInput, 5);
        transactionToDateInput.clear();
        transactionFromDateInput.clear();
        transactionFromDateInput.sendKeys(fromDate);
        transactionToDateInput.sendKeys(toDate);
    }

    public void selectTypeDropDownOption(String option) {
        BrowserUtils.waitForVisibility(transactionTypeDropDown, 5);
        Select select = new Select(transactionTypeDropDown);
        select.selectByVisibleText(option);
    }

    public void clickOnFindButton() {
        BrowserUtils.clickWithWait(findButton);

    }

    public List<String> getDatesList() {
        List<String> dates = new ArrayList<>();
        BrowserUtils.wait(2);
        for (WebElement each : displayedDateElements) {
            if (!each.getText().isEmpty()) {
                dates.add(each.getText());
            }
        }

        return dates;
    }

    public List<String> getDescriptionList(){
        BrowserUtils.wait(2);
        return BrowserUtils.getListOfString(displayedDescriptionElement);
    }

    public List<String> getDepositsList(){
        BrowserUtils.wait(2);
        return BrowserUtils.getListOfString(displayedDepositElements);
    }

    public List<String> getWithdrawalsList(){
        BrowserUtils.wait(2);
        return BrowserUtils.getListOfString(displayedWithdrawalElements);
    }







}
