package junit5;

import AstonTesting.junit5.ArithmeticOperations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArithmeticTest {
    private ArithmeticOperations calculator = new ArithmeticOperations();

    @Test
    void testAdd() {
        Assertions.assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void testSubtract() {
        Assertions.assertEquals(-1, calculator.subtract(2, 3));
    }

    @Test
    void testMultiply() {
        Assertions.assertEquals(6, calculator.multiply(2, 3));
    }

    @Test
    void testDivide() {
        Assertions.assertEquals(0.666, calculator.divide(2, 3), 0.001);
    }
}