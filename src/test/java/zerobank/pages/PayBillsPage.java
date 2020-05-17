package zerobank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import zerobank.utilities.BrowserUtils;
import zerobank.utilities.Driver;

import java.util.List;
import java.util.Map;

public class PayBillsPage  extends  BasePage{

    @FindBy(css = "[id ='sp_amount']")
    private WebElement amountInputBox;

    @FindBy(id = "sp_date")
    private WebElement dateInputBox;

    @FindBy(id = "sp_description")
    private WebElement descriptionInputBox;

    @FindBy(id="pay_saved_payees")
    private WebElement payButton;

    @FindBy(css = "[id=alert_content] span")
    private WebElement alertMessage;

    @FindBy(id = "np_new_payee_name")
    private WebElement newPayeeName;

    @FindBy(id = "np_new_payee_address")
    private WebElement newPayeeAddress;

    @FindBy(id = "np_new_payee_account")
    private WebElement newPayeeAccount;

    @FindBy(id = "np_new_payee_details")
    private WebElement newPayeeDetails;

    @FindBy(id = "add_new_payee")
    private WebElement newPayeeSubmit;

    @FindBy(linkText = "Add New Payee")
    private WebElement addNewPayeeTab;

    @FindBy(id="pc_currency")
    private WebElement currencyDropdown;

    @FindBy(linkText = "Purchase Foreign Currency")
    private WebElement purchaseForeignCurrencyTab;

    @FindBy(id = "purchase_cash")
    private WebElement purchaseButton;

    public void clickPurchaseButton(){
        BrowserUtils.waitForVisibility(purchaseButton,3);
        BrowserUtils.clickWithWait(purchaseButton);
    }

    public void selectCurrency(String option){
        BrowserUtils.waitForVisibility(currencyDropdown,5);
        Select select = new Select(currencyDropdown);
        select.selectByVisibleText(option);
    }

    public List<String> currencyList(){
        BrowserUtils.waitForVisibility(currencyDropdown,5);
        Select select = new Select(currencyDropdown);
        return BrowserUtils.getListOfString(select.getOptions());
    }

    public void makePayment(Double amount, String date, String description){
        if(amount != null){
            amountInputBox.sendKeys(""+amount);
        }
        if(date != null) {
            dateInputBox.sendKeys(date);
        }
        descriptionInputBox.sendKeys(description);
    }
    public void makePayment(Double amount, String date) {
        if(amount != null){
            amountInputBox.sendKeys(""+amount);
        }
        if(date != null) {
            dateInputBox.sendKeys(date);
        }
    }

    public void clickPayButton(){
        payButton.click();
    }

    public void sentKeysAmountInputBox(String amount) {
        BrowserUtils.waitForVisibility(this.amountInputBox,5);
        if( !amount.equals("null")) { this.amountInputBox.sendKeys(amount); }
    }

    public void sendKeysDateInputBox(String date) {
        BrowserUtils.waitForVisibility(this.dateInputBox,5);
        if(date != null){ this.dateInputBox.sendKeys(date); }
    }

    public void sendKeysDescriptionInputBox(String description) {
        if(description != null){ this.descriptionInputBox.sendKeys();}
    }

    public String getAlertMessage(){
        return alertMessage.getText();
    }

    public String getErrorValidationMessage(){
        if(!this.amountInputBox.getAttribute("validationMessage").isEmpty()){
            return this.amountInputBox.getAttribute("validationMessage"); }
        else { return this.dateInputBox.getAttribute("validationMessage"); }
    }

    public String getInputBoxText(String inputBox){
        if(inputBox.equalsIgnoreCase("Amount")){
            System.out.println(amountInputBox.getAttribute("value"));
            return amountInputBox.getAttribute("value");
        }else if(inputBox .equalsIgnoreCase("Date")){
            System.out.println(dateInputBox.getAttribute("value"));
            return dateInputBox.getAttribute("value");
        }else if (inputBox.equalsIgnoreCase("description")){
            System.out.println(amountInputBox.getText());
            return descriptionInputBox.getText();
        }else{
            return null;
        }
    }

    public void newPayeeFormFill(Map<String, String> data){
        BrowserUtils.waitForVisibility(newPayeeName,5);
        newPayeeName.sendKeys(data.get("Payee Name"));
        newPayeeAddress.sendKeys(data.get("Payee Address"));
        newPayeeAccount.sendKeys(data.get("Account"));
        newPayeeDetails.sendKeys(data.get("Payee details"));

        newPayeeSubmit.click();
    }

    public void clickAddNewPayee(){
        BrowserUtils.clickWithWait(addNewPayeeTab);
    }

    public String addNewPayeeAlertMessage(){
        BrowserUtils.waitForVisibility(Driver.get().findElement(By.cssSelector("[id='alert_container']")),5);
        return Driver.get().findElement(By.cssSelector("[id='alert_container']")).getText();
    }

    public void clickPurchaseForeignCurrencyTab(){
        BrowserUtils.clickWithWait(purchaseForeignCurrencyTab);
    }






}
