package zerobank.utilities;

import zerobank.pages.AccountActivityPage;
import zerobank.pages.AccountSummaryPage;
import zerobank.pages.LoginPage;
import zerobank.pages.PayBillsPage;

public class Pages {


    private AccountActivityPage accountActivityPage;
    private AccountSummaryPage accountSummaryPage;
    private LoginPage loginPage;
    private PayBillsPage payBillsPage;

    public AccountActivityPage accountActivityPage() {
        if(accountActivityPage == null){
            accountActivityPage = new AccountActivityPage();
        }
        return accountActivityPage;
    }

    public AccountSummaryPage accountSummaryPage() {
        if(accountSummaryPage == null){
            accountSummaryPage = new AccountSummaryPage();
        }
        return accountSummaryPage;
    }

    public LoginPage loginPage() {
        if(loginPage == null){
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public PayBillsPage payBillsPage() {
        if(payBillsPage==null){
            payBillsPage = new PayBillsPage();
        }
        return payBillsPage;
    }
}
