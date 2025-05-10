package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InstallmentPlan {
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
    void testFromPlan() {
        mainPage.open();
        mainPage.acceptCookie();
        mainPage.dropdownClick();
        mainPage.selectPlan();
        assertTrue(mainPage.accountNumber(), "Плейсхолдер поля 'Номер счета' не содержит ожидаемого текста");
        assertTrue(mainPage.sumLabel(), "Плейсхолдер поля 'Сумма' не содержит ожидаемого текста");
        assertTrue(mainPage.emailLabel(), "Плейсхолдер поля 'E-mail' не содержит ожидаемого текста");
    }
}