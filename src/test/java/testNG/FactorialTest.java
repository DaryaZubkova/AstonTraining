package testNG;

import AstonTesting.testNG.Factorial;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialTest {
    private final Factorial factorial = new Factorial();

    @Test(dataProvider = "factorialData")
    public void testFactorial(int number, long expected) {
        assertEquals(expected, factorial.calculate(number));
    }

    @DataProvider(name = "factorialData")
    public Object[][] factorialData() {
        return new Object[][]{
                {0, 1},
                {1, 1},
                {5, 120}
        };
    }
}