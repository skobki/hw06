package webDriverFactory;

public enum BrowserName {
    //Перечисление браузеров
    CHROME("chrome"),
    FIREFOX("firefox"),
    EDGE("edge");

    private String browserName;

    private BrowserName(String browserName) {
        this.browserName = browserName;
    }

    @Override
    public String toString() {
        return String.valueOf(this.browserName);
    }

    public static BrowserName fromString(String browserName) {
        if (browserName != null) {
            for(BrowserName b : BrowserName.values()) {
                if (browserName.equalsIgnoreCase(b.browserName)) {
                    return b;
                }
            }
        }
        return null;
    }

    public String getBrowserName() {
        return this.browserName;
    }
}
