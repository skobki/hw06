package models.valueObjects;

public class MaxDiagonal {
    private int maxDiagonal;

    public MaxDiagonal() {

    }
    public MaxDiagonal(int maxDiagonal) {
        if (maxDiagonal >= 22 && maxDiagonal <= 100) {
            this.maxDiagonal = maxDiagonal;
        } else {
            throw new IllegalArgumentException("Максимальная диагональ должна быть больше 22 и меньше 88");
        }
    }
    public String getMaxDiagonal() {
        String convertedMaxDiagonal = String.valueOf(this.maxDiagonal);
        return convertedMaxDiagonal;
    }
    public boolean equals(MaxDiagonal otherMaxDiagonal) {
        return this.maxDiagonal == otherMaxDiagonal.maxDiagonal;
    }
}
