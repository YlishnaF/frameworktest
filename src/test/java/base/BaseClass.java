package base;

import framework.managers.DriverManager;
import framework.managers.InitManager;
import framework.managers.PageManager;
import framework.managers.TestPropManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseClass {
    private final DriverManager driverManager = DriverManager.getInstance();
    protected PageManager pageManager = PageManager.getInstance();
    private final TestPropManager propManager = TestPropManager.getInstance();

    @BeforeAll
    public static void beforeClass(){
        InitManager.initFramework();
    }

    @BeforeEach
    void before() {
        driverManager.getDriver().get(propManager.getProperty("base.url"));
    }

    @AfterAll
    public static void afterAll() {

        InitManager.quitFramework();
    }

}