package pages;

public enum PageName {
    START_PAGE("Стартовая страница"),
    TV_PAGE("Страница \"Телевизоры\""),
    TV_PRODUCT_PAGE("Страница \"Продукт. Телевизор\"");
    private String pageName;

    private PageName(String pageName) {
        this.pageName = pageName;
    }

    @Override
    public String toString() {
        return String.valueOf(this.pageName);
    }
    public static PageName fromString(String pageName) {
        if (pageName != null) {
            for(PageName p : PageName.values()) {
                if (pageName.equalsIgnoreCase(p.pageName)) {
                    return p;
                }
            }
        }
        return null;
    }
    public String getPageName() {
        return this.pageName;
    }

}
