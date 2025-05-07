package AstonTesting.junit5;

public class NumberComparator {
    public String compare(int a, int b) {
        if (a > b) {
            return a + " больше " + b;
        } else if (a < b) {
            return a + " меньше " + b;
        } else {
            return "Числа равны";
        }
    }
}