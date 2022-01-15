import base.BaseClass;
import org.junit.jupiter.api.*;

public class RgsTest extends BaseClass {
    @Test
    @DisplayName("test insurance request form")
    //   @RepeatedTest(name="{displayName} : repetition {currentRepetition} of {totalRepetitions}", value = 3)
    public void test() throws InterruptedException {
        pageManager.getStartPage()
                .closeCookies()
                .selectBaseMenuByText("Компаниям")
                .clickSubMenuByText("Здоровье")
                .clickSpanMenuByText("Добровольное медицинское страхование")
                .clickBtnSendRequest()
                .fillFields("Ваши ФИО", "Tigr Petrovich")
                .fillFields("Ваш адресс", "London")
                .fillFields("Ваша почта", "ertuienfbdhf")
                .checkBoxClick()
                .clickSendForm();
    }
}