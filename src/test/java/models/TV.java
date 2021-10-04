package models;

import models.valueObjects.*;

import java.io.Serializable;

public class TV implements Serializable {
    private Company company;
    private Frequency frequency;
    private LEDType ledType;
    private MaxDiagonal maxDiagonal;
    private MinDiagonal minDiagonal;

    public TV() {

    }

    public TV(Company company, Frequency frequency, LEDType ledType, MaxDiagonal maxDiagonal, MinDiagonal minDiagonal) {
        this.company = company;
        this.frequency = frequency;
        this.ledType = ledType;
        this.maxDiagonal = maxDiagonal;
        this.minDiagonal = minDiagonal;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
    public Company getCompany() {
        return this.company;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }
    public Frequency getFrequency() {
        return this.frequency;
    }

    public void setLedType(LEDType ledType) {
        this.ledType = ledType;
    }
    public LEDType getLedType() {
        return this.ledType;
    }

    public void setMaxDiagonal(MaxDiagonal maxDiagonal) {
        this.maxDiagonal = maxDiagonal;
    }
    public MaxDiagonal getMaxDiagonal() {
        return this.maxDiagonal;
    }

    public void setMinDiagonal(MinDiagonal minDiagonal) {
        this.minDiagonal = minDiagonal;
    }
    public MinDiagonal getMinDiagonal() {
        return this.minDiagonal;
    }
}
