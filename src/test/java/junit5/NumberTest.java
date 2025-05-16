package junit5;

import AstonTesting.junit5.NumberComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberTest {
    private NumberComparator comparator = new NumberComparator();

    @Test
    void testOne() {
        String result = comparator.compare(7, 5);
        Assertions.assertEquals("7 больше 5", result);
    }

    @Test
    void testTwo() {
        String result = comparator.compare(4, 8);
        Assertions.assertEquals("4 меньше 8", result);
    }

    @Test
    void testThree() {
        String result = comparator.compare(5, 5);
        Assertions.assertEquals("Числа равны", result);
    }
}