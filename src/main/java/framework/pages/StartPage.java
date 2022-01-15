package framework.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;


public class StartPage extends BasePage{

    @FindBy(xpath = "//button[@class= \"btn--text\"]")
    private WebElement closeCookiesButton;

    @FindBy(xpath = "//li[@class=\"item text--second\"]/a[contains(@class, \"text--second\")]")
    List<WebElement> baseMenu;

    @Step("Закрыть окно cookie")
    public StartPage closeCookies() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        waitElementToBeClicable(closeCookiesButton);
        closeCookiesButton.click();
        return pageManager.getStartPage();
    }

    /**
     * Клик по базоврму меню
     * @param textMenu - текст меню, переданный пользователем
     */
    @Step("Клик по базоврму меню '{textMenu}'")
    public ForCompaniesPage selectBaseMenuByText(String textMenu) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        for (WebElement itemMenu :
                baseMenu) {
            if (itemMenu.getText().contains(textMenu)) {
                waitElementToBeClicable(itemMenu);
                itemMenu.click();
                return pageManager.getForCompaniesPage();
            }
        }

        Assertions.fail("Меню ч текстом " + textMenu + " не найдено на стартовой странице");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class = 'item text--basic current']")));
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return pageManager.getForCompaniesPage();

    }
}
