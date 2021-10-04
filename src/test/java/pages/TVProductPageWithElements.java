package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageElements.Link;
import pageElements.TextInElement;

public class TVProductPageWithElements extends BasePage {
    private Logger logger = LogManager.getLogger(TVProductPageWithElements.class);

    public TVProductPageWithElements(WebDriver driver) {
        super(driver);
    }

    //----Локаторы----
    //Характеристики
    String specificationsLinkXpath = "//div[@class=\"product-card-tabs__head\"]//a[contains(text(), \"Характеристики\")]";
    //Поле "Модель"
    String productModelXpath = "//table[@class=\"table-params table-no-bordered\"]//span[contains(text(), \"Модель\")]/ancestor-or-self::tr/td[2]/div";
    //Поле "Диагональ экрана (дюйм)"
    String productDiagonalXpath = "//table[@class=\"table-params table-no-bordered\"]//span[contains(text(), \"Диагональ экрана (дюйм)\")]/ancestor-or-self::tr/td[2]/div";
    //Поле "Частота обновления экрана"
    String productFrequencyXpath = "//table[@class=\"table-params table-no-bordered\"]//span[contains(text(), \"Частота обновления экрана\")]/ancestor-or-self::tr/td[2]/div";
    //Поле "Тип подсветки экрана"
    String productLedTypeXpath = "//table[@class=\"table-params table-no-bordered\"]//span[contains(text(), \"Тип подсветки экрана\")]/ancestor-or-self::tr/td[2]/div";

    //Получение заголовка страницы
    public String getPageTitle() {
        String title = driver.getTitle();
        logger.info("Заголовок страницы: " + title);
        return title;
    }
    //Ссылка "Характеристики"
    public void specificationsLinkClick() {
        Link specificationsLink = new Link(driver, By.xpath(specificationsLinkXpath));
        specificationsLink.focusOnLink();
        logger.info("Курсор наведен на ссылку \"Характеристики\"");
        specificationsLink.click();
        logger.info("Нажата ссылка \"Характеристики\"");
    }
    //Получение текста из элемента "Модель"
    public String getProductModel() {
        TextInElement textInModelElement = new TextInElement(driver, By.xpath(productModelXpath));
        return textInModelElement.getTextOfElement();
    }
    //Получение текста из элемента "Диагональ"
    public String getProductDiagonal() {
        TextInElement textInDiagonalElement = new TextInElement(driver, By.xpath(productDiagonalXpath));
        return textInDiagonalElement.getTextOfElement();
    }
    //Получение текста из элемента "Частота"
    public String getProductFrequency() {
        TextInElement textInFrequencyElement = new TextInElement(driver, By.xpath(productFrequencyXpath));
        return textInFrequencyElement.getTextOfElement();
    }
    //Получение текста из элемента "Тип подсветки"
    public String getProductLedType() {
        TextInElement textInLedType = new TextInElement(driver, By.xpath(productLedTypeXpath));
        return textInLedType.getTextOfElement();
    }
}
