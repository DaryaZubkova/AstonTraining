package junit5;

import AstonTesting.junit5.Factorial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactorialTest {
    private Factorial calculate = new Factorial();

    @Test
    void testOne() {
        Assertions.assertEquals(1, calculate.calculate(1));
    }

    @Test
    void testNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculate.calculate(-1));
    }
}