package facadeSteps;

import helpers.ScreenshotMaker;
import helpers.JSExec;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.TVProductPageWithElements;

public class TVProductPageSteps {
    private Logger logger = LogManager.getLogger(TVProductPageSteps.class);
    private TVProductPageWithElements tvProductPage;

    public TVProductPageSteps(TVProductPageWithElements tvProductPage) {
        this.tvProductPage = tvProductPage;
        logger.info("Открыта страница [Продукт. Телевизор]");
    }

    public String pageTitle() {
        return tvProductPage.getPageTitle();
    }

    public void specificationsClick() {
        JSExec.scrollBy(0, 500);
        tvProductPage.specificationsLinkClick();
    }

    public String productModel() {
        return tvProductPage.getProductModel();
    }

    public String productLedType() {
        return tvProductPage.getProductLedType();
    }

    public String productDiagonal() {
        return tvProductPage.getProductDiagonal();
    }

    public String productFrequency() {
        return tvProductPage.getProductFrequency();
    }
}
