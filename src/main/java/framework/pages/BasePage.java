package framework.pages;

import framework.managers.DriverManager;
import framework.managers.PageManager;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected DriverManager driverManager = DriverManager.getInstance();
    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(),15,1000);
    protected PageManager pageManager =PageManager.getInstance();

    public BasePage() {
        PageFactory.initElements(driverManager.getDriver(),this);
    }

    protected void fillInputField(WebElement element, String value) {
        scrollToElement(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Actions actions = new Actions(driverManager.getDriver());
        actions.click(element);
//        element.click();
//        element.submit();
        element.clear();
        element.sendKeys(value);
    }


    protected void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driverManager.getDriver()).executeScript(
                "arguments[0].scrollIntoView();", element);
    }

    protected WebElement waitElementToBeClicable(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
