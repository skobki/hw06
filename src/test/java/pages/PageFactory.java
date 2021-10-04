package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class PageFactory {
    private static Logger logger = LogManager.getLogger(PageFactory.class);
    private static BasePage getPage(WebDriver driver, PageName name) {
        switch (name) {
            case START_PAGE:
                logger.info("Стартовая страница");
                StartPageWithElements startPageWithElements = new StartPageWithElements(driver);
                return startPageWithElements;
            case TV_PAGE:
                logger.info("Страница \"Телевизоры\"");
                TVPageWithElements tvPageWithElements = new TVPageWithElements(driver);
                return tvPageWithElements;
            case TV_PRODUCT_PAGE:
                logger.info("Страница\"Продукт. Телевизор\"");
                TVProductPageWithElements tvProductPageWithElements = new TVProductPageWithElements(driver);
                return tvProductPageWithElements;
            default:
                throw new RuntimeException("Некорректное наименование страницы (Page object)");
        }
    }
}
