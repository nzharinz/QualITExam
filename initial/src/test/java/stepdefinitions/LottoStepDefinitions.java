package stepdefinitions;

import common.InvalidApplicationState;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pageobjectsLotto.HomePage;
import pageobjectsLotto.LoggedInUserPage;
import pageobjectsLotto.LoginPage;
import utilities.BrowserDriver;

public class LottoStepDefinitions {

    private HomePage hPage;
    private LoginPage lPage;
    private LoggedInUserPage loggedInUserPage;

    @Given("^I am in \"([^\"]*)\"$")
    public void iAmIn(String url) {
        BrowserDriver.getDriver().get(url);
    }

    @When("^I click 'Log in'$")
    public void iClickLogIn() throws InvalidApplicationState {
        hPage = new HomePage(BrowserDriver.getDriver());
        hPage.clickOnLoginButtons();
    }

    @Given("^I am in the lotto home page$")
    public void iAmInTheLottoHomePage() {
        Assert.assertTrue(hPage.isUserOnAppHomePage(), "Application has not been launched successfully");
    }

    @And("^login as \"([^\"]*)\" with password \"([^\"]*)\"$")
    public void loginAsWithPassword(String username, String password) throws InvalidApplicationState {
        lPage = new LoginPage(BrowserDriver.getDriver());
        lPage.loginWithCredentials(username, password);
    }

    @Then("^I should land on my personal landing page$")
    public void iShouldLandOnMyPersonalLandingPage() throws InvalidApplicationState {
        loggedInUserPage = new LoggedInUserPage(BrowserDriver.getDriver());
        Assert.assertTrue(loggedInUserPage.isLoginSuccessful(), "Login Failed");
    }

    @And("^I verify email ID \"([^\"]*)\"$")
    public void iVerifyEmailID(String email) throws Throwable {
        String actualEmail = loggedInUserPage.getAccountEmail();
        Assert.assertEquals(actualEmail, email, "Invalid email");

    }

    @And("^I logout from lotto account$")
    public void iLogoutFromLottoAccount() {
        loggedInUserPage.logout();
        Assert.assertTrue(hPage.isUserOnAppHomePage());
    }

}
