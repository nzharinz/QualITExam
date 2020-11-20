package stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.BrowserDriver;

public class BaseTest {

    @Before
    public void setupBrowser() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\hari.emani\\Downloads\\LIB\\chromedriver_win32\\chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.setExperimentalOption("useAutomationExtension", false);
        BrowserDriver.setDriver(new ChromeDriver(options));
    }


    @After
    public void tearDown() {
        BrowserDriver.getDriver().quit();
    }

}
