package pageElements;

import helpers.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextInElement extends BaseElement  {
    public TextInElement (WebDriver driver, By by) {
        super(driver, by);
    }


    public String getTextOfElement() {
        WaitFor.visibilityOfElementLocated(by);
        return webElement.getText();
    }
}
