package models.valueObjects;

import java.io.Serializable;

public class Frequency implements Serializable {
    private int frequency;

    public Frequency() {

    }

    public Frequency(int frequency) {
        if (frequency > 0) {
            this.frequency = frequency;
        } else {
            throw new IllegalArgumentException("Частота должна быть больше 0");
        }
    }
    public String getFrequency() {
        String convertedFrequency = String.valueOf(this.frequency);
        return convertedFrequency;
    }
    public boolean equals(Frequency otherFrequency) {
        return this.frequency == otherFrequency.frequency;
    }
}
