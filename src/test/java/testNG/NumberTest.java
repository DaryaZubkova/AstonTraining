package testNG;

import AstonTesting.testNG.NumberComparator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberTest {
    private final NumberComparator comparator = new NumberComparator();

    @Test(dataProvider = "comparisonData")
    public void testCompareNumber(int a, int b, String expected) {
        assertEquals(expected, comparator.compare(a, b));
    }

    @DataProvider(name = "comparisonData")
    public Object[][] comparisonData() {
        return new Object[][]{
                {7, 5, "7 больше 5"},
                {4, 8, "4 меньше 8"},
                {5, 5, "Числа равны"}
        };
    }
}