package webDriverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

public class FirefoxBrowser {
    //Специфичные настройки страницы
    public static WebDriver getDriver(StrategyName strategy) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        switch (strategy) {
            case NORMAL:
                options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, PageLoadStrategy.NORMAL);
                break;
            case EAGER:
                options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, PageLoadStrategy.EAGER);
                break;
            case NONE:
                options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, PageLoadStrategy.NONE);
                break;
            default:
                throw new RuntimeException("Неправильное имя стратегии. Используйте NORMAL/EAGER/NONE");
        }
        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        options.addArguments("-private");
        options.addArguments("-kiosk");

        return new FirefoxDriver(options);
    }
}
