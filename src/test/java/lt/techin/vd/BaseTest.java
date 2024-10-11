package lt.techin.vd;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    protected LoginPage loginPage;
    protected RegistrationPage registrationPage;
    protected CalculatorPage calculatorPage;
    protected OperationsPerformedPage operationsPerformedPage;
    protected EditPage editPage;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        calculatorPage = new CalculatorPage(driver);
        operationsPerformedPage = new OperationsPerformedPage(driver);
        editPage = new EditPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://localhost:8080/prisijungti");

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
