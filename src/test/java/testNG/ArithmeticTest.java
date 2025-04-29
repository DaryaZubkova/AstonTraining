package testNG;
import AstonTesting.testNG.ArithmeticOperations;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArithmeticTest {
    private final ArithmeticOperations calculator = new ArithmeticOperations();

    @Test(dataProvider = "additionData")
    public void testAdd(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b));
    }

    @DataProvider(name = "additionData")
    public Object[][] additionData() {
        return new Object[][]{
                {2, 3, 5}
        };
    }

    @Test(dataProvider = "subtractionData")
    public void testSubtraction(int a, int b, int expected) {
        assertEquals(expected, calculator.subtract(a, b));
    }

    @DataProvider(name = "subtractionData")
    public Object[][] subtractionData() {
        return new Object[][]{
                {5, 3, 2}
        };
    }

    @Test(dataProvider = "multiplicationData")
    public void testMultiPly(int a, int b, int expected) {
        assertEquals(expected, calculator.multiply(a, b));
    }

    @DataProvider(name = "multiplicationData")
    public Object[][] multiplicationData() {
        return new Object[][]{
                {2, 3, 6}
        };
    }

    @Test(dataProvider = "divisionData")
    public void testDivide(int a, int b, int expected) {
        assertEquals(expected, calculator.divide(a, b));
    }

    @DataProvider(name = "divisionData")
    public Object[][] divisionData() {
        return new Object[][]{
                {6, 2, 3}
        };
    }
}