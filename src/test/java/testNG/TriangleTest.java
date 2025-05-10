package testNG;
import AstonTesting.testNG.TriangleArea;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {
    private final TriangleArea calculate = new TriangleArea();

    @Test(dataProvider = "positiveTriangle")
    public void testPositive(double base, double height, double expected) {
        assertEquals(expected, calculate.calculate(base, height));
    }

    @DataProvider(name = "positiveTriangle")
    public Object[][] positiveTriangle() {
        return new Object[][]{
                {5, 4, 10},
        };
    }

    @Test(dataProvider = "negativeTriangle")
    public void testNegative(double base, double height) {
        assertThrows(IllegalArgumentException.class, () -> calculate.calculate(base, height));
    }

    @DataProvider(name = "negativeTriangle")
    public Object[][] negativeTriangle() {
        return new Object[][]{
                {-5, -4}
        };
    }
}