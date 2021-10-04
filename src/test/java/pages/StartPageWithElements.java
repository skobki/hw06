package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageElements.Link;

public class StartPageWithElements extends BasePage{
    private Logger logger = LogManager.getLogger(StartPageWithElements.class);

    private final String URL = "https://www.dns-shop.ru/";

    //----Локаторы----
    //"Да" на всплывающем окне
    String linkYesXpath = "//a[contains(text(), \"Да\")]";
    //Ссылка "ТВ и мультимедиа"
    String linkTVAndMultimediaXpath = "(//a[contains(text(), \"ТВ и мультимедиа\")])[1]";
    //Ссылка "Телевизоры"
    String linkTVXpath = "(//a[contains(text(), \"Телевизоры\")])[2]";

    //Конструктор класса
    public StartPageWithElements(WebDriver driver) {
        //Родительский конструктор
        super(driver);
    }

    public String getURL() {
        return this.URL;
    }

    public void openPage() {
        driver.get(this.URL);
        logger.info("Открыта страница https://www.dns-shop.ru/");
    }

    public void linkYesClick() {
        Link linkYes = new Link(driver, By.xpath(linkYesXpath));
        linkYes.click();
        logger.info("Нажата кнопка \"Да\"");
    }

    public void linkTVAndMultimediaMove() {
        Link linkTVAndMultimedia = new Link(driver, By.xpath(linkTVAndMultimediaXpath));
        linkTVAndMultimedia.focusOnLink();
        logger.info("Курсор мыши наведен на ссылку \"ТВ и мультимедиа\"");
    }

    public void linkTVClick() {
        Link linkTV = new Link(driver, By.xpath(linkTVXpath));
        linkTV.click();
        logger.info("Нажата ссылка \"Телевизоры\"");
    }
}
