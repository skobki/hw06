package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSExec {
    private static Logger logger = LogManager.getLogger(JSExec.class);

    //Исполнитель JS
    protected static JavascriptExecutor js;
    //Инициализация исполнителя JS
    public static void initJS(WebDriver driver) {
        js = (JavascriptExecutor) driver;
    }
    //Скролл страницы на заданное расстояние по Х и У
    public static void scrollBy(int x, int y) {
        String script = "window.scrollBy(" + x + "," + y + ");";
        js.executeScript(script);
    }
    //Установка невидимости веб элемента
    public static void displayNone(WebElement element) {
        String script = "arguments[0].style.display='none';";
        js.executeScript(script, element);
    }
}
