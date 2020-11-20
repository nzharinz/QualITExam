package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {
    protected WebDriver driver;
    protected long timeOut = 60;

    public BasePage(WebDriver driver) throws InvalidApplicationState {
        this.driver = driver;
        this.checkForGoodAppState();
    }

    public abstract Object onValidPage();

    private void checkForGoodAppState() throws InvalidApplicationState {
        Object object = onValidPage();
        if (!object.equals(true)) {
            throw new InvalidApplicationState(object.toString());
        }
    }

    protected WebElement findById(String loc) {
        return new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOfElementLocated(By.id(loc)));
    }

    protected WebElement findByXPath(String loc) {
        return new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc)));
    }

    protected WebElement findByName(String loc) {
        return new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOfElementLocated(By.name(loc)));
    }

    protected List<WebElement> findElementsByXpath(String loc) {
        return new WebDriverWait(driver, timeOut).until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(loc), 0));
    }

    protected void sendCharacters(WebElement element, String value) {
        element.clear();
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            String s = new StringBuilder().append(c).toString();
            element.sendKeys(s);
        }
    }

}
