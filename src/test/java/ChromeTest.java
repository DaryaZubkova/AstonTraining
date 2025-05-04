import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ChromeTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void testPage() {
        driver.get("https://www.mts.by/");
        String actualTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pay-section']//h2[contains(., 'Онлайн пополнение')]"))).getText().trim();
        System.out.println("Заголовок блока: " + actualTitle);
        Assertions.assertAll(
                () -> Assertions.assertTrue(actualTitle.contains("без комиссии")),
                () -> Assertions.assertEquals("Онлайн пополнение\nбез комиссии", actualTitle)
        );
    }
}