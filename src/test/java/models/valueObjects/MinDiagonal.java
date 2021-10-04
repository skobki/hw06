package models.valueObjects;

import java.io.Serializable;

public class MinDiagonal implements Serializable {
    private int minDiagonal;

    public MinDiagonal() {

    }

    public MinDiagonal(int minDiagonal) {
        if (minDiagonal >= 22 && minDiagonal <= 100) {
            this.minDiagonal = minDiagonal;
        } else {
            throw new IllegalArgumentException("Минимальная диагональ должна быть больше 22 и меньше 88");
        }
    }
    public String getMinDiagonal() {
        String convertedMinDiagonal = String.valueOf(this.minDiagonal);
        return convertedMinDiagonal;
    }
    public boolean equals(MinDiagonal otherMinDiagonal) {
        return this.minDiagonal == otherMinDiagonal.minDiagonal;
    }
}
