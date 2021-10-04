package pages;

import helpers.ScreenshotMaker;
import helpers.JSExec;
import helpers.WaitFor;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BasePage {
    protected static WebDriver driver;

    public BasePage (WebDriver driver) {
        BasePage.driver = driver;
        //Инициализация ожидания 10 секунд
        WaitFor.initWait(driver, Duration.ofSeconds(10), Duration.ofMillis(100));
        //Инициализация исполнителя JS
        JSExec.initJS(driver);
    }
}
