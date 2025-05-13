package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import static org.junit.jupiter.api.Assertions.*;

public class FormTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void testPage() throws InterruptedException {
        mainPage.open();
        mainPage.acceptCookie();

        if (mainPage.phoneMaskCorrect()) {
            System.out.println("Маска +375 найдена");
        }

        String testPhoneNumber = "(29)777-77-77";
        mainPage.enterPhoneNumber(testPhoneNumber);
        String enteredValue = mainPage.getEnteredPhoneNumber();
        System.out.println("Введенный номер: " + enteredValue);
        assertNotNull(enteredValue, "Пустое поле");
        assertEquals(testPhoneNumber, enteredValue, "Введенный номер не совпадает с ожидаемым");
        String testSum = "100";
        mainPage.enterSum(testSum);
        String enteredSum = mainPage.getEnteredSum();
        System.out.println("Введенная сумма: " + enteredSum);
        assertNotNull(enteredSum, "Сумма введена неверно");
        assertEquals(testSum, enteredSum, "Введенная сумма не совпадает с ожидаемой");
        Thread.sleep(500);
        mainPage.clickContinueButton();
        mainPage.checkSum();
        mainPage.checkPhone();
        mainPage.buttonSum();
        mainPage.checkCardNumber();
        mainPage.setPeriodOption();
        mainPage.checkCvcOption();
        mainPage.checkNameOfCard();
        mainPage.allLogos();
    }
}