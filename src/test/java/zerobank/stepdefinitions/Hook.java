package zerobank.stepdefinitions;

import io.cucumber.core.api.Scenario;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import zerobank.utilities.Driver;

public class Hook {


    @Before
    public void setUP(){
        Driver.get().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            System.out.println("Test failed");
            byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
            Driver.close();
        }else {
            System.out.println("Test Complete");
        }




        Driver.close();
    }
}





