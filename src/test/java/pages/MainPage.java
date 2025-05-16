package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By cookieButton = By.xpath("//button[@id='cookie-agree']");
    private final By phoneInput = By.id("connection-phone");
    private final By sumInput = By.id("connection-sum");
    private final By continueButton = By.xpath("//button[@class='button button__default ']");
    private final By emailInput = By.id("connection-email");
    private final By dropdownButton = By.xpath("//button [@class='select__header']");
    private final By homeInternetOption = By.xpath("//div[@id='pay-section']//section//ul/li[p]");
    private final By planOption = By.xpath("//p[@class='select__option' and text()='Рассрочка']");
    private final By accountInput = By.xpath("//input[@id='score-instalment']");
    private final By arrearsButton = By.xpath("//p[@class='select__option' and text()='Задолженность']");
    private final By arrearsOption = By.xpath("//input[@id='score-arrears']");
    private By paymentFrame = By.xpath("//iframe[@class='bepaid-iframe']");
    private By checkSum = By.xpath("//span[text()[contains(.,'100')]]");
    private By checkPhone = By.xpath("//div[@class='pay-description__text']/span");
    private By buttonSum = By.xpath("//button[@class='colored disabled' and contains(., '100.00 BYN')]");
    private final By cardNumber = By.xpath("//label[@class ='ng-tns-c2312288139-1 ng-star-inserted']");
    private final By periodOption = By.xpath("//label[@class = 'ng-tns-c2312288139-4 ng-star-inserted']");
    private final By cvcOption = By.xpath("//label[@class = 'ng-tns-c2312288139-5 ng-star-inserted']");
    private final By nameOfCard = By.xpath("//label[@class = 'ng-tns-c2312288139-3 ng-star-inserted']");
    public final By allLogos = By.cssSelector("img[src*='system']:not([style*='opacity: 0'])");

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


    public boolean isPaymentFrameDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(paymentFrame)).isDisplayed();
    }

    public String checkSum() {
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentFrame));
            WebElement checkSumElement = wait.until(ExpectedConditions.visibilityOfElementLocated(checkSum));
            String amount = checkSumElement.getText();
            return amount;
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    public String checkPhone() {
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentFrame));
            WebElement checkPhoneElement = wait.until(ExpectedConditions.visibilityOfElementLocated(checkPhone));
            String text = checkPhoneElement.getText();
            return text;
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    public String buttonSum() {
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentFrame));
            WebElement buttonSumElement = wait.until(ExpectedConditions.visibilityOfElementLocated(buttonSum));
            String text = buttonSumElement.getText();
            return text;
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    public boolean allLogos() {
        try {
            List<WebElement> icons = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(allLogos));
            if (icons.isEmpty()) {
                return false;
            }
            for (WebElement icon : icons) {
                if (!icon.isDisplayed()) {
                    return false;
                }
            }
            return true;

        } catch (TimeoutException e) {
            return false;
        }
    }
}