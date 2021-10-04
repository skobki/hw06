package facadeSteps;

import helpers.ScreenshotMaker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.StartPageWithElements;

public class StartPageSteps {
    private Logger logger = LogManager.getLogger(StartPageSteps.class);

    private StartPageWithElements startPage;

    public StartPageSteps(StartPageWithElements startPage) {
        this.startPage = startPage;
        logger.info("Открыта страница [Стартовая страница DNS]");
    }

    public void clickLinkTv() {
        startPage.linkYesClick();
        startPage.linkTVAndMultimediaMove();
        startPage.linkTVClick();
    }
}
