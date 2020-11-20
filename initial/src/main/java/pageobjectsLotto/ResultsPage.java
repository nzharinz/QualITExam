package pageobjectsLotto;

import common.BasePage;
import common.InvalidApplicationState;
import org.openqa.selenium.WebDriver;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public abstract class ResultsPage extends BasePage {

//    private String userNameLoc;
//    private String pWordLoc = "//input[@id='password']";
    private String BullseyeResults = "//button[@name='nav-menu-main-results-text']";

    public ResultsPage(WebDriver driver) throws InvalidApplicationState {
        super(driver);
    }

//    @Override
//    public Object onValidPage() {
//        this.userNameLoc = "//input[@id='nav-menu-main-results-text']";
//        try {
//            return findByXPath(userNameLoc).isDisplayed();
//        } catch (Exception e) {
//            return "User is not in the login page of the application";
//        }
//    }

    public void Results() {
        
        findByXPath(BullseyeResults).click();
    }
}
