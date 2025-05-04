import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class LogoTest {
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
        List<WebElement> paymentLogos = wait.until(driver -> driver.findElements(By.xpath("//*[@id='pay-section']//img")));
        System.out.println("Найдено логотипов: " + paymentLogos.size());
        paymentLogos.forEach(logo ->
                System.out.println("Логотип: " + logo.getAttribute("alt") + " (src: " + logo.getAttribute("src") + ")"));
        Assertions.assertFalse(paymentLogos.isEmpty(), "Не найдено ни одного логотипа!");
        Assertions.assertTrue(paymentLogos.get(0).isDisplayed(), "Первый логотип не отображается!");
    }
}