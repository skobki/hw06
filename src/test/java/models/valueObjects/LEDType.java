package models.valueObjects;

import java.io.Serializable;
import java.util.Objects;

public class LEDType implements Serializable {
    private String ledType;

    public LEDType() {

    }
    public LEDType(String ledType) {
        if (!ledType.isBlank() || !ledType.isEmpty()) {
            this.ledType = ledType;
        } else {
            throw new IllegalArgumentException("Наименование типа подсветки экрана не может быть пустым");
        }
    }
    public String getLedType() {
        return this.ledType;
    }

    public boolean equals(LEDType otherLedType) {
        return this.ledType.equals(otherLedType.ledType);
    }
}
