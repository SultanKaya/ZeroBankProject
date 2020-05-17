package zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import zerobank.utilities.Driver;

public class BasePage {

    BasePage() { PageFactory.initElements(Driver.get(),this); }

    @FindBy (id = "account_summary_tab")
    private WebElement accountSummaryTab;

    @FindBy(id="account_activity_tab")
    private WebElement accountActivityTab;

    @FindBy(id = "transfer_funds_tab")
    private WebElement transferFundsTab;

    @FindBy(id = "pay_bills_tab")
    private WebElement payBillsTab;

    @FindBy(id="money_map_tab")
    private WebElement moneyMapTab;

    @FindBy(id = "online_statements_tab")
    private WebElement onlineStatementsTab;

    public void  navigateTo(String tab){
        WebElement module =
                tab.equalsIgnoreCase("Account Summary")?accountSummaryTab:
                        tab.equalsIgnoreCase("Account Activity")?accountActivityTab:
                                tab.equalsIgnoreCase("Transfer Funds")?transferFundsTab:
                                        tab.equalsIgnoreCase("Pay Bills")?payBillsTab:
                                                tab.equalsIgnoreCase("Money Map")?moneyMapTab:
                                                        tab.equalsIgnoreCase("Online Statements")?onlineStatementsTab:null;

        if(module !=null){
            module.click();
        }else{
            System.out.println("Invalid tab");
        }
    }

    public void logOut(){

    }

}
