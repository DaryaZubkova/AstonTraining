package AstonTesting.testNG;

public class Factorial {
    public long calculate(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Факториал отрицательного числа не найден");
        }
        if (number == 0 || number == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}