import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LinkTest {
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
        try {
            WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='cookie-agree']")));
            cookieButton.click();
        } catch (Exception e) {
            System.out.println("Куки-баннер не найден" + e.getMessage());
        }
        try {
            WebElement chatWidget = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'webim-root')]//*[contains(@class,'webim-close')]")));
            chatWidget.click();
            Thread.sleep(300);
        } catch (Exception e) {
            System.out.println("Виджет чата не обработан: " + e.getMessage());
        }
        WebElement paymentLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(., 'Подробнее о сервисе')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", paymentLink);
        String linkHref = paymentLink.getAttribute("href");
        System.out.println("URL ссылки: " + linkHref);
        assertNotNull(linkHref, "Ссылка не имеет атрибута href");
        assertFalse(linkHref.isEmpty(), "Атрибут пустой");
        paymentLink.click();
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe("https://www.mts.by/")));
        System.out.println("Переход успешен. Текущий URL: " + driver.getCurrentUrl());
    }
}