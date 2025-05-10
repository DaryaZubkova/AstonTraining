package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By cookieButton = By.xpath("//*[@id='cookie-agree']");
    private final By phoneInput = By.xpath("//*[@id='connection-phone']");
    private final By sumInput = By.xpath("//*[@id='connection-sum']");
    private final By continueButton = By.xpath("//*[@id='pay-connection']/button");
    private final By emailInput = By.xpath("//*[@id='connection-email']");
    private final By dropdownButton = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button");
    private final By homeInternetOption = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button/span[1]");
    private final By planOption = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[3]/p");
    private final By accountInput = By.xpath("//*[@id='score-instalment']");
    private final By arrearsButton = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[4]/p");
    private final By arrearsOption = By.xpath("//*[@id='score-arrears']");
    private final By checkSum = By.xpath("//*[contains(text(),'100')]");
    private final By buttonSum = By.xpath("//*[contains(text(),'100')]");
    private final By checkPhone = By.xpath("//*[contains(text(),'375')]");
    private final By cardNumber = By.xpath("//input[@placeholder='Номер карты']");
    private final By periodOption = By.xpath("//app-card-input//form//app-input[1]//input");
    private final By cvcOption = By.xpath("//app-card-input//form//div[2]//div[3]//app-input//input");
    private final By nameOfCard = By.xpath("//app-card-input//form//div[3]//app-input//input");
    private final By visaIcon = By.xpath("//img[contains(@src, 'visa')]");
    private final By mastercardIcon = By.xpath("//img[contains(@src, 'mastercard')]");
    private final By belcardIcon = By.xpath("//img[contains(@src, 'belkart') or contains(@alt, 'Белкарт')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void open() {
        driver.get("https://www.mts.by/");
    }

    public void acceptCookie() {
        try {
            WebElement cookieButtonElement = wait.until(ExpectedConditions.elementToBeClickable(cookieButton));
            cookieButtonElement.click();
        } catch (Exception e) {
            System.out.println("Куки-баннер не найден: " + e.getMessage());
        }
    }

    public void enterPhoneNumber(String phoneNumber) {
        WebElement phoneInputElement = wait.until(ExpectedConditions.presenceOfElementLocated(phoneInput));
        phoneInputElement.sendKeys(phoneNumber);
    }

    public boolean phoneMaskCorrect() {
        WebElement phoneInputElement = wait.until(ExpectedConditions.presenceOfElementLocated(phoneInput));
        String placeholder = phoneInputElement.getAttribute("placeholder");
        return placeholder != null && placeholder.contains("+375");
    }

    public void enterSum(String sum) {
        WebElement sumInputElement = wait.until(ExpectedConditions.presenceOfElementLocated(sumInput));
        sumInputElement.sendKeys(sum);
    }

    public void clickContinueButton() {
        WebElement continueButtonElement = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueButtonElement);
    }

    public boolean phoneLabel() {
        WebElement phoneInt = wait.until(ExpectedConditions.presenceOfElementLocated(phoneInput));
        String placeholder = phoneInt.getAttribute("placeholder");
        return placeholder != null && placeholder.contains("Номер телефона");
    }

    public boolean sumLabel() {
        WebElement sumElement = wait.until(ExpectedConditions.presenceOfElementLocated(sumInput));
        String placeholder = sumElement.getAttribute("placeholder");
        return placeholder != null && placeholder.contains("Сумма");
    }

    public boolean emailLabel() {
        WebElement emailElement = wait.until(ExpectedConditions.presenceOfElementLocated(emailInput));
        String placeholder = emailElement.getAttribute("placeholder");
        return placeholder != null && placeholder.contains("E-mail для отправки чека");
    }

    public String getEnteredPhoneNumber() {
        WebElement phoneInputElement = wait.until(ExpectedConditions.presenceOfElementLocated(phoneInput));
        return phoneInputElement.getAttribute("value");
    }

    public String getEnteredSum() {
        WebElement sumInputElement = wait.until(ExpectedConditions.presenceOfElementLocated(sumInput));
        return sumInputElement.getAttribute("value");
    }

    public void dropdownClick() {
        WebElement dropdownButtonElement = wait.until(ExpectedConditions.elementToBeClickable(dropdownButton));
        dropdownButtonElement.click();
    }

    public void selectHomeInternet() {
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(homeInternetOption));
        option.click();
    }

    public void selectPlan() {
        WebElement optionPlan = wait.until(ExpectedConditions.elementToBeClickable(planOption));
        optionPlan.click();
    }

    public boolean accountNumber() {
        WebElement accountNumberElement = wait.until(ExpectedConditions.presenceOfElementLocated(accountInput));
        String placeholder = accountNumberElement.getAttribute("placeholder");
        return placeholder != null && placeholder.contains("Номер счета на 44");

    }

    public void selectArrears() {
        WebElement optionArrears = wait.until(ExpectedConditions.elementToBeClickable(arrearsButton));
        optionArrears.click();
    }

    public boolean accountNumberArrears() {
        WebElement numberArrears = wait.until(ExpectedConditions.presenceOfElementLocated(arrearsOption));
        String placeholder = numberArrears.getAttribute("placeholder");
        return placeholder != null && placeholder.contains("Номер счета на 2073");
    }

    public void checkSum() {
        WebElement checkSumElement = wait.until(ExpectedConditions.presenceOfElementLocated(checkSum));
        checkSumElement.getAttribute("value");
    }

    public void buttonCheckSum() {
        WebElement buttonCheckSumElement = wait.until(ExpectedConditions.presenceOfElementLocated(buttonSum));
        buttonCheckSumElement.getAttribute("value");
    }

    public void checkPhone() {
        WebElement checkPhoneNumber = wait.until(ExpectedConditions.presenceOfElementLocated(checkPhone));
        checkPhoneNumber.getAttribute("value");
    }

    public boolean checkCardNumber() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumber));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean setPeriodOption() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(periodOption));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean checkCvcOption() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(cvcOption));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean checkNameOfCard() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(nameOfCard));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void checkLogoVisa() {
        WebElement visaIconElement = wait.until(ExpectedConditions.presenceOfElementLocated(visaIcon));
        visaIconElement.getAttribute("value");
    }

    public void checkLogoMaster() {
        WebElement masterLogo = wait.until(ExpectedConditions.presenceOfElementLocated(mastercardIcon));
        masterLogo.getAttribute("value");
    }

    public void checkLogoBelcard() {
        WebElement belcardLogo = wait.until(ExpectedConditions.presenceOfElementLocated(belcardIcon));
        belcardLogo.getAttribute("value");
    }
}