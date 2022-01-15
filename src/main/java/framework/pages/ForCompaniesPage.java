package framework.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ForCompaniesPage extends BasePage{
    @FindBy(xpath = "//span[@class = \"padding\"] | //li[@class = \"item text--second\"]/span/a[@class and @target]")
    List<WebElement> subMenu;

    @FindBy(xpath = "//div[@class = \"header-list-products\"]//a")
    List<WebElement> spanMenu;

    @Step
    public ForCompaniesPage clickSubMenuByText(String textMenu){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
//        if(textMenu.equals("Перестрахование")){
//        //    return Перестрахование Page
//        }
        for (WebElement itemMenu :
                subMenu) {
            if (itemMenu.getText().contains(textMenu)) {
                waitElementToBeClicable(itemMenu).click();
                return pageManager.getForCompaniesPage();
            }
        }
        Assertions.fail("Меню c текстом " + textMenu + " не найдено на странице для компаний");
        return pageManager.getForCompaniesPage();
    }
    @Step
    public InsurancePage clickSpanMenuByText(String textMenu){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        for (WebElement itemMenu :
                spanMenu) {
            if (itemMenu.getText().contains(textMenu)) {
                waitElementToBeClicable(itemMenu).click();
                return pageManager.getInsurancePage();
            }
        }
        //       wait.until(ExpectedConditions.elementToBeClickable(health));
        Assertions.fail("Меню c текстом " + textMenu + " не найдено на странице для компаний");
        return pageManager.getInsurancePage();
    }
}
