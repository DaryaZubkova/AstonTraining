package AstonTesting.junit5;

public class TriangleArea {
    public double calculate(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Основание и высота должны быть положительными");
        }
        return (base * height) / 2;
    }
}