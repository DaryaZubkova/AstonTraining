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
@DisplayName("Тестирование формы 'Домашний интернет'")
public class HomeInternet {
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
    @Description("Тест проверяет переход на услугу 'Домашний интернет', проверка плейсхолдеров в полях")
    void testFormInternet() {
        Allure.step("1. Открытие главной страницы", () -> {
            mainPage.open();
            mainPage.acceptCookie();
        });

        Allure.step("2. Нажатие на выпадающее меню, выбор услуги 'Домашний интернет'", () -> {
            mainPage.dropdownClick();
            mainPage.selectHomeInternet();
        });

        Allure.step("3. Проверка маски +375", () -> {
            if (mainPage.phoneMaskCorrect()) {
                System.out.println("Маска +375 найдена");
            }
        });

        Allure.step("4. Проверка плейсхолдеров в полях", () -> {
            assertTrue(mainPage.phoneLabel(), "Плейсхолдер поля 'Номер телефона' не содержит ожидаемого текста");
            assertTrue(mainPage.sumLabel(), "Плейсхолдер поля 'Сумма' не содержит ожидаемого текста");
            assertTrue(mainPage.emailLabel(), "Плейсхолдер поля 'E-mail' не содержит ожидаемого текста");
        });
    }
}