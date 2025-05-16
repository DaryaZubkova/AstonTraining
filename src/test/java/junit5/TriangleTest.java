package junit5;

import AstonTesting.junit5.TriangleArea;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {
    private TriangleArea calculate = new TriangleArea();

    @Test
    void testPositive() {
        Assertions.assertEquals(10, calculate.calculate(5, 4));
    }

    @Test
    void testNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculate.calculate(-5, -4));
    }
}