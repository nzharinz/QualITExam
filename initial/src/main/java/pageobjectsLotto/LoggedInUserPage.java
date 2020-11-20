package pageobjectsLotto;

import common.BasePage;
import common.InvalidApplicationState;
import org.openqa.selenium.WebDriver;

public class LoggedInUserPage extends BasePage {

    private String accountButton;
    private String accountEmail = "//p[@class='accountEmail']";
    private String logoutButton = "//a[@id='nav-item-log-out-link']";

    public LoggedInUserPage(WebDriver driver) throws InvalidApplicationState {
        super(driver);
    }


    @Override
    public Object onValidPage() {
        this.accountButton = "//a[@id='nav-menu-account-link']//span[@class='navSvgWrapper']";
        try {
            return findByXPath(accountButton).isDisplayed();
        } catch (Exception e) {
            return "User has not been logged into the application";
        }
    }

    private void clickOnAccountButton() {
        findByXPath(accountButton).click();
    }

    public String getAccountEmail() {
        clickOnAccountButton();
        return findByXPath(accountEmail).getText();
    }

    public boolean isLoginSuccessful() {
        return findByXPath(accountButton).isDisplayed();
    }

    public void logout() {
        findByXPath(logoutButton).click();
    }


}
