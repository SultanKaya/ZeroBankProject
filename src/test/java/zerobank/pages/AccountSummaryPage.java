package zerobank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import zerobank.utilities.BrowserUtils;
import zerobank.utilities.Driver;

import java.util.List;

public class AccountSummaryPage  extends BasePage {

    @FindBy(css = "[class='board-header']")
    private List<WebElement> accountTypeElements;





    public List<String> accountTypes(){
        return BrowserUtils.getListOfString(accountTypeElements);
    }

    public List<String> tableColumns(String table){
        int tableNumber= (table.equalsIgnoreCase("Credit Accounts"))?3:0;
        List<WebElement> tableColumns;
        tableColumns = Driver.get().findElements(By.xpath("//*[@class='offset2 span8']/div["+tableNumber+"]/div/table/thead/tr/th"));

        if(table.equalsIgnoreCase("Credit Accounts")){
            return BrowserUtils.getListOfString(tableColumns);
        }

        return null;
    }

    public void clickAccountTypeLink(String accountType){
        WebElement type = Driver.get().findElement(By.xpath("//a[contains(text(),'"+accountType+"')]"));
        type.click();
    }

}
