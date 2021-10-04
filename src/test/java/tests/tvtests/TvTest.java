package tests.tvtests;

import helpers.GetUrl;
import helpers.ScreenshotMaker;
import facadeSteps.StartPageSteps;
import facadeSteps.TVPageSteps;
import facadeSteps.TVProductPageSteps;
import models.TV;
import models.TVBuilder;
import models.valueObjects.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pages.StartPageWithElements;
import pages.TVPageWithElements;
import pages.TVProductPageWithElements;
import tests.BaseTest;
import tests.assertions.TVProductPageAssert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TvTest extends BaseTest {
    String expectedCompany = "Samsung";
    int expectedFrequency = 120;
    String expectedLedType = "Direct LED";
    int expectedMaxDiagonal = 80;
    int expectedMinDiagonal = 60;
    String expectedTitle = "Купить 75\" (189 см) Телевизор LED Samsung QE75Q950TSUXRU серый в интернет магазине DNS. Характеристики, цена Samsung QE75Q950TSUXRU | 8165296";

    @Order(1)
    @Test
    public void selectedProductIsSomeSamsungTv() {
        //1. Arrange
        String expectedTitle = this.expectedTitle;
        TVBuilder builder = new TVBuilder(
                new Company(this.expectedCompany),
                new Frequency(this.expectedFrequency),
                new LEDType(this.expectedLedType),
                new MaxDiagonal(this.expectedMaxDiagonal),
                new MinDiagonal(this.expectedMinDiagonal)
        );
        TV tv = builder.build();

        //2. Act
        TVProductPageSteps tvProductPageSteps = getProductPage(tv);

        //3. Assert
        TVProductPageAssert pageTitleAssert = new TVProductPageAssert(tvProductPageSteps);

        pageTitleAssert.pageTitleEquals(expectedTitle);
    }

    @Order(2)
    @Test
    public void productPageSpecificationsTest() {
        //1. Arrange
        String expectedCompany = this.expectedCompany;
        int expectedFrequency = this.expectedFrequency;
        String expectedLedType = this.expectedLedType;
        int expectedMaxDiagonal = this.expectedMaxDiagonal;
        int expectedMinDiagonal = this.expectedMinDiagonal;
        //2. Act
        TVProductPageSteps tvProductPageSteps1 = getSpecificationsPage();
        //3. Assert
        TVProductPageAssert specificationsAssert = new TVProductPageAssert(tvProductPageSteps1);

        specificationsAssert.productCompanyEquals(this.expectedCompany);

        specificationsAssert.productFrequencyEquals(String.valueOf(this.expectedFrequency) + " Гц");

        specificationsAssert.productDiagonalEquals(this.expectedMinDiagonal, this.expectedMaxDiagonal);

        specificationsAssert.productLedTypeEquals(this.expectedLedType);

    }

    public TVProductPageSteps getProductPage(TV tv) {
        //Открыть страницу DNS
        driver.get("https://www.dns-shop.ru/");
        //Стартовая страница
        StartPageSteps startPageSteps = new StartPageSteps(new StartPageWithElements(driver));
        //Нажатие на ссылку "Телевизоры"
        startPageSteps.clickLinkTv();
        //
        //Страница "Телевизоры"
        TVPageSteps tvPageSteps = new TVPageSteps(new TVPageWithElements(driver));
        //Скриншот
        ScreenshotMaker.MakeAScreenshot("png", "(1)tvPage", driver);
        //Сортировка "Сначала дорогие"
        tvPageSteps.orderByExpensiveFirst();
        //Фильтр "Производитель"
        tvPageSteps.filterByCompany(tv.getCompany());
        //Фильтр "Диагональ (дюйм)"
        tvPageSteps.filterByDiagonal(tv.getMinDiagonal(), tv.getMaxDiagonal());
        //Фильтр "Частота обновления экрана"
        tvPageSteps.filterByFrequency(tv.getFrequency());
        //Фильтр "Тип подсветки экрана"
        tvPageSteps.filterByLedType(tv.getLedType());
        //Нажатие на кнопку "Применить"
        tvPageSteps.clickButtonApply();
        //Скриншот
        ScreenshotMaker.MakeAScreenshot("png", "(2)sortedTvPage", driver);
        //Нажатие на первый продукт в списке
        tvPageSteps.firstProductClick("Телевизор LED Samsung QE75Q950TSUXRU серый");
        //
        GetUrl.writeCurrentUrlInFile(driver);
        //Страница "Продукт. Телевизор"
//        TVProductPageSteps tvProductPageSteps = new TVProductPageSteps(new TVProductPageWithElements(driver));
//        //Скриншот
//        ScreenshotMaker.MakeAScreenshot("png", "(3)firstProduct", driver);
//        //Нажата кнопка "Характеристики"
//        tvProductPageSteps.specificationsClick();
//        //Скриншот
//        ScreenshotMaker.MakeAScreenshot("png", "(4)specifications", driver);
        return new TVProductPageSteps(new TVProductPageWithElements(driver));
    }

    public TVProductPageSteps getSpecificationsPage () {
        driver.get(GetUrl.getUrlFromFile());
        TVProductPageSteps tvProductPageSteps = new TVProductPageSteps(new TVProductPageWithElements(driver));
        //Скриншот
        ScreenshotMaker.MakeAScreenshot("png", "(3)firstProduct", driver);
        //Нажата кнопка "Характеристики"
        tvProductPageSteps.specificationsClick();
        //Скриншот
        ScreenshotMaker.MakeAScreenshot("png", "(4)specifications", driver);
        return new TVProductPageSteps(new TVProductPageWithElements(driver));
    }
}
