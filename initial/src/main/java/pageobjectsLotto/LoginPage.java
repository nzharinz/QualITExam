package pageobjectsLotto;

import common.BasePage;
import common.InvalidApplicationState;
import org.openqa.selenium.WebDriver;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {

    private String userNameLoc;
    private String pWordLoc = "//input[@id='password']";
    private String loginButton = "//button[@name='login']";
//    private String skip = "xpath=//a[contains(@href,'skip')";

    public LoginPage(WebDriver driver) throws InvalidApplicationState {
        super(driver);
    }

    @Override
    public Object onValidPage() {
        this.userNameLoc = "//input[@id='email']";
        try {
            return findByXPath(userNameLoc).isDisplayed();
        } catch (Exception e) {
            return "User is not in the login page of the application";
        }
    }

    public void loginWithCredentials(String username, String password) {
        sendCharacters(findByXPath(userNameLoc), username);
        sendCharacters(findByXPath(pWordLoc), password);
        findByXPath(loginButton).click();
//        findByXPath(skip).click();
    }
}
