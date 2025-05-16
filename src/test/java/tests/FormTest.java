package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import static org.junit.jupiter.api.Assertions.*;

@Epic("Тесты формы оплаты")
@Feature("Основной функционал формы")
@DisplayName("Тестирование формы ввода платежных данных")
public class FormTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    @Step("Инициализация драйвера и открытие страницы")
    void setupTest() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
    }

    @AfterEach
    @Step("Закрытие браузера")
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Story("Проверка ввода данных")
    @DisplayName("Проверка корректности заполнения формы")
    @Description("Тест проверяет ввод номера телефона, суммы и отображение элементов формы")
    @Severity(SeverityLevel.CRITICAL)
    void testPage() throws InterruptedException {
        Allure.step("1. Открытие главной страницы", () -> {
            mainPage.open();
            mainPage.acceptCookie();
        });

        Allure.step("2. Проверка маски номера телефона", () -> {
            if (mainPage.phoneMaskCorrect()) {
                System.out.println("Маска +375 найдена");
            }
        });

        Allure.step("3. Ввод номера телефона", () -> {
            String testPhoneNumber = "(29)777-77-77";
            mainPage.enterPhoneNumber(testPhoneNumber);
            String enteredValue = mainPage.getEnteredPhoneNumber();
            System.out.println("Введенный номер: " + enteredValue);
            assertNotNull(enteredValue, "Пустое поле");
            assertEquals(testPhoneNumber, enteredValue, "Введенный номер не совпадает с ожидаемым");
        });

        Allure.step("4. Ввод суммы платежа", () -> {
            String testSum = "100";
            mainPage.enterSum(testSum);
            String enteredSum = mainPage.getEnteredSum();
            System.out.println("Введенная сумма: " + enteredSum);
            assertNotNull(enteredSum, "Сумма введена неверно");
            assertEquals(testSum, enteredSum, "Введенная сумма не совпадает с ожидаемой");
        });

        Allure.step("5. Проверка элементов формы", () -> {
            Thread.sleep(500);
            mainPage.clickContinueButton();
            mainPage.checkSum();
            mainPage.checkPhone();
            mainPage.buttonSum();
            mainPage.checkCardNumber();
            mainPage.setPeriodOption();
            mainPage.checkCvcOption();
            mainPage.checkNameOfCard();

            Allure.step("Проверка логотипов", mainPage::allLogos);
        });
    }
}