package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ScreenshotMaker {
    private static Logger logger = LogManager.getLogger(ScreenshotMaker.class);
    protected static Screenshot screenshotMaker;

    public static void MakeAScreenshot(String format, String name, WebDriver driver) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            screenshotMaker = new AShot().takeScreenshot(driver);
            ImageIO.write(screenshotMaker.getImage(), format, new File("temp\\" + name + "." + format));
            logger.info("Скриншот сохранен в [temp/" + name + "." + format + "]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
