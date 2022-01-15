package framework.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.XpiDriverService;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InsurancePage extends BasePage{
    @FindBy(xpath = "//button/span[contains(text(), \"Отправить заявку\")]")
    WebElement bntSendRequest;
    @FindBy(xpath = "//input[@name=\"userName\"]")
    WebElement userName;
    @FindBy (xpath ="//input[@name=\"userTel\"]")
    WebElement phoneNumber;
    @FindBy(xpath =  "//input[@placeholder=\"Введите\"]")
    WebElement address;
    @FindBy(xpath = "//input[@name=\"userEmail\"]")
    WebElement userEmail;
    @FindBy(xpath = "//div[@ class=\"checkbox-body form__checkbox\" ]/input")
    WebElement checkbox;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement sendForm ;
    @Step
    public InsurancePage clickBtnSendRequest(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        waitElementToBeClicable(bntSendRequest).click();
        return pageManager.getInsurancePage();
    }
    @Step
    public InsurancePage fillFields(String nameField, String value){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        WebElement element = null;
        switch (nameField){
            case "Ваши ФИО":
                element=userName;
                fillInputField(userName, value);
                break;
            case "Номер телефона":
                element=phoneNumber;
                fillInputField(phoneNumber, value);
                break;
            case"Ваша почта":
                element=userEmail;
                fillInputField(userEmail,value);
                break;
            case "Ваш адресс":
                element=address;
                fillInputField(address, value);
                break;
            default:
                Assertions.fail("Поле "+ nameField+ " не найдено");
        }
        Assertions.assertEquals(element.getAttribute("value"), value);
        return pageManager.getInsurancePage();
    }
    @Step
    public InsurancePage checkBoxClick(){
        Actions actions = new Actions(driverManager.getDriver());
        scrollToElement(driverManager.getDriver().findElement(By.xpath("//div[@class=\"form-submit\"]")));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"form-submit\"]")));
        actions.moveToElement(checkbox).click(checkbox).build().perform();
        return this;
    }
    @Step
    public InsurancePage clickSendForm(){try {
        Thread.sleep(1000);
    } catch (InterruptedException e){
        e.printStackTrace();
    }
        waitElementToBeClicable(sendForm).click();
        return this;
    }

    public InsurancePage isEmailCorrect(){
        Assertions.assertEquals(userEmail.findElement(By.xpath("/../../span")).getText(),
                "Введите корректный адрес электронной почты");
        return this;
    }

}
