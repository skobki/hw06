package webDriverFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    private static Logger logger = LogManager.getLogger(WebDriverFactory.class);

    public static WebDriver getDriver(BrowserName name, StrategyName strategy) {
        switch (name) {
            case CHROME:
                logger.info("Драйвер браузера Google Chrome");
                return ChromeBrowser.getDriver(strategy);
            case FIREFOX:
                logger.info("Драйвер браузера Firefox");
                return FirefoxBrowser.getDriver(strategy);
            case EDGE:
                logger.info("Драйвер браузера MS EDGE");
                return EdgeBrowser.getDriver(strategy);
            default:
                throw new RuntimeException("Некорректное имя браузера");
        }
    }
}
