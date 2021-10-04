package pages;

import helpers.WaitFor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Text;
import pageElements.*;

public class TVPageWithElements extends BasePage {
    private Logger logger = LogManager.getLogger(TVPageWithElements.class);

    public TVPageWithElements(WebDriver driver) {
        super(driver);
    }

    //----Локаторы----
    //Шапка
    String mainBlockXpath = "//header";
    //Фильтры
    //Производитель
    String checkBoxCompanyXpath = "//span[contains(text(), \"company\")]";
    //Частота
    String accordeonFrequencyXpath = "//div[@class=\"ui-list-controls ui-collapse ui-collapse_list\"]//span[contains(text(), \"Частота обновления экрана (Гц)\")]";
    String checkBoxFrequencyXpath = "//span[contains(text(), \"frequency\")]";
    //Диагональ
    String accordeonDiagonalXpath = "//div[@class=\"ui-collapse ui-collapse_list\"]//span[contains(text(), \"Диагональ экрана (дюйм)\")]";
    String textBoxMinDiagonalXpath = "//input[@placeholder=\"от 22\"]";
    String textBoxMaxDiagonalXpath = "//input[@placeholder=\"до 100\"]";
    //Тип подсветки экрана
    String accordeonLedTypeXpath = "//div[@class=\"ui-list-controls ui-collapse ui-collapse_list\"]//span[contains(text(), \"Тип подсветки экрана\")]";
    String checkBoxLedTypeXpath = "//span[contains(text(), \"ledType\")]";
    //Сортировка
    String accordeonSortXpath = "//span[contains(text(), \"Сортировка:\")]/following::a";
    String radioButtonExpensiveXpath = "//span[contains(text(), \"Сначала дорогие\")]";
    //Кнопка "Применить"
    String buttonApplyXpath = "//button[contains(text(), \"Применить\")]";
    //Ссылка на первый продукт в списке
    String linkFirstProductXpath = "(//a[contains(@class, \"catalog-product__name\")])[1]";

    //Сокрытие шапки
    public void mainBlockHide() {
        MainBlock mainBlock = new MainBlock(driver, By.xpath(mainBlockXpath));
        mainBlock.hide();
    }
    //Сортировка по цене
    public void accordeonSortClick() {
        Accordeon accordeonSort = new Accordeon(driver, By.xpath(accordeonSortXpath));
        accordeonSort.show();
        logger.info("Нажата выпадашка \"Сортировка\"");
    }
    //Сначала дорогие
    public void radioButtonExpensiveClick() {
        RadioButton radioButtonExpensive = new RadioButton(driver, By.xpath(radioButtonExpensiveXpath));
        radioButtonExpensive.setSelected(true);
        logger.info("Установлениа сортировка \"Сначала дорогие\"");
    }
    //Фильтр "Производитель"
    public void checkBoxCompanyClick(String company) {
        checkBoxCompanyXpath = checkBoxCompanyXpath.replace("company", company);
        CheckBox checkBoxCompany = new CheckBox(driver, By.xpath(checkBoxCompanyXpath));
        checkBoxCompany.setChecked(true);
        logger.info("Установлен филтьр \"Производитель\" - " + company);
    }
    //Фильтр "Частота"
    public void accordeonFrequencyClick() {
        Accordeon accordeonFrequency = new Accordeon(driver, By.xpath(accordeonFrequencyXpath));
        accordeonFrequency.show();
        logger.info("Отображены значения фильтра \"Частота обновления экрана\"");
    }
    public void checkBoxFrequencyClick(String frequency) {
        checkBoxFrequencyXpath = checkBoxFrequencyXpath.replace("frequency", frequency);
        CheckBox checkBoxFrequency = new CheckBox(driver, By.xpath(checkBoxFrequencyXpath));
        checkBoxFrequency.setChecked(true);
        logger.info("Установлен фильтр \"Частота обновления экрана\" - " + frequency);
    }
    //Фильтр "Диагональ экрана"
    public void accordeonDiagonalClick() {
        Accordeon accordeonDiagonal = new Accordeon(driver, By.xpath(accordeonDiagonalXpath));
        accordeonDiagonal.show();
        logger.info("Отображены значения фильтра \"Диагональ экрана\"");
    }
    //~Минимальная
    public void textBoxMinDiagonalSetValue(String diagonal) {
        TextBox textBoxMinDiagonal = new TextBox(driver, By.xpath(textBoxMinDiagonalXpath));
        textBoxMinDiagonal.click();
        logger.info("Нажато поле для ввода минимальной диагонали экрана");
        textBoxMinDiagonal.setValue(diagonal);
        logger.info("Введено минимальное значение диагонали экрана: " + diagonal);
    }
    //~Максимальная
    public void textBoxMaxDiagonalSetValue(String diagonal) {
        TextBox textBoxMaxDiagonal = new TextBox(driver, By.xpath(textBoxMaxDiagonalXpath));
        textBoxMaxDiagonal.click();
        logger.info("Нажато поле для ввода максимальной диагонали экрана");
        textBoxMaxDiagonal.setValue(diagonal);
        logger.info("Введено максимальное значение диагонали экрана: " + diagonal);
    }
    //Фильтр "Тип подсветки экрана"
    public void accordeonLedTypeClick() {
        Accordeon accordeonLedType = new Accordeon(driver, By.xpath(accordeonLedTypeXpath));
        accordeonLedType.show();
        logger.info("Отображены значения фильтра \"Диагональ экрана\"");
    }
    public void checkBoxLedTypeClick(String ledType) {
        checkBoxLedTypeXpath = checkBoxLedTypeXpath.replace("ledType", ledType);
        CheckBox checkBoxLedType = new CheckBox(driver, By.xpath(checkBoxLedTypeXpath));
        checkBoxLedType.setChecked(true);
        logger.info("Установлен фильтр \"Тип подсветки экрана\" - " + ledType);
    }
    //Нажать на кнопку "Применить"
    public void buttonApplyClick() {
        Button buttonApply = new Button(driver, By.xpath(buttonApplyXpath));
        buttonApply.click();
        logger.info("Нажата кнопка \"Применить\"");
    }
    //Первый продукт в списке
    public void linkFirstProductClick(String product) {
        WaitFor.firstProductMustBe(By.xpath(linkFirstProductXpath), product);
        Link linkProduct = new Link(driver, By.xpath(linkFirstProductXpath));
        linkProduct.click();
        logger.info("Нажата ссылка первого продукта в списке");
    }
}
