package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import webDriverFactory.BrowserName;
import webDriverFactory.StrategyName;
import webDriverFactory.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(BaseTest.class);
    //Базовые настройки теста
    @BeforeEach
    public void setUp() {
        //Параметризированный запуск тестов.
        //-Dbrowser
        String browser = System
                .getProperty("browser", "chrome")
                .toLowerCase();
        //-Doption
        String strategy = System
                .getProperty("option", "normal")
                .toUpperCase();
        driver = WebDriverFactory.getDriver(BrowserName.fromString(browser), StrategyName.fromString(strategy));
        logger.info("Драйвер запущен");
        //Общие настройки таймаута загрузки страницы
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @AfterEach
    public void setDown() {
        if(driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен");
        }
    }
}
