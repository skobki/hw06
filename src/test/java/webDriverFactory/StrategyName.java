package webDriverFactory;

public enum StrategyName {
    NORMAL("NORMAL"),
    EAGER("EAGER"),
    NONE("NONE");

    private String strategyName;

    private StrategyName(String strategyName) {
        this.strategyName = strategyName;
    }

    @Override
    public String toString() {
        return String.valueOf(this.strategyName);
    }

    public static StrategyName fromString(String strategyName) {
        if(strategyName != null) {
            for(StrategyName strat : StrategyName.values()) {
                if (strategyName.equalsIgnoreCase(strat.strategyName)) {
                    return strat;
                }
            }
        }
        return null;
    }

    public String getStrategyName() {
        return this.strategyName;
    }
}
