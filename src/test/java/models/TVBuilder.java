package models;

import models.valueObjects.*;

public class TVBuilder {
    private Company company;
    private Frequency frequency;
    private LEDType ledType;
    private MaxDiagonal maxDiagonal;
    private MinDiagonal minDiagonal;

    public TVBuilder(Company company, Frequency frequency, LEDType ledType, MaxDiagonal maxDiagonal, MinDiagonal minDiagonal) {
        this.company = company;
        this.frequency = frequency;
        this.ledType = ledType;
        this.maxDiagonal = maxDiagonal;
        this.minDiagonal = minDiagonal;
    }
    public TV build() {
        TV tv = new TV();
        tv.setCompany(this.company);
        tv.setFrequency(this.frequency);
        tv.setLedType(this.ledType);
        tv.setMinDiagonal(this.minDiagonal);
        tv.setMaxDiagonal(this.maxDiagonal);
        return tv;
    }
}
