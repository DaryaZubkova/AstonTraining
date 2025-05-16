import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

public class FormTest {
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
    void testPage() throws InterruptedException {
        driver.get("https://www.mts.by/");
        try {
            WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='cookie-agree']")));
            cookieButton.click();
        } catch (Exception e) {
            System.out.println("Куки-баннер не найден" + e.getMessage());
        }
        WebElement phoneInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='connection-phone']")));
        String placeholder = phoneInput.getAttribute("placeholder");
        if (placeholder != null && placeholder.contains("+375")) {
            System.out.println("Маска +375 найдена в плейсхолдере");
        }
        String testPhoneNumber = "(29)777-77-77";
        phoneInput.sendKeys(testPhoneNumber);
        String enteredValue = phoneInput.getAttribute("value");
        System.out.println("Введенный номер: " + enteredValue);
        assertNotNull(enteredValue, "Поле не содержит значения");
        assertEquals(testPhoneNumber, enteredValue, "Введенный номер не совпадает с ожидаемым");
        WebElement sumInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='connection-sum']")));
        String testSum = "100";
        sumInput.sendKeys(testSum);
        String enteredSum = sumInput.getAttribute("value");
        System.out.println("Введенная сумма: " + enteredSum);
        assertNotNull(enteredSum, "Поле суммы неверное");
        assertEquals(testSum, enteredSum, "Введенная сумма не совпадает с ожидаемой");
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-connection']/button")));
        Thread.sleep(500);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueButton);
    }
}