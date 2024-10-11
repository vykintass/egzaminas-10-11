package lt.techin.vd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalculatorPage extends BasePage {
    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".nav.navbar-nav.navbar-right > a")
    private WebElement logoutButton;
    @FindBy(css = "form#number > input[name='sk1']")
    private WebElement number1;
    @FindBy(css = "form#number > input[name='sk2']")
    private WebElement number2;
    @FindBy(css = "[type='submit']")
    private WebElement calculateButton;
    @FindBy(css = "span#sk2\\.errors")
    private WebElement errorMessage;
    @FindBy(linkText = "Atliktos operacijos")
    private WebElement OperationPerformedButton;

    public String getLogoutButtonText() {
        return logoutButton.getText();
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }

    public void inputNumber1(String number) {
        number1.clear();
        number1.sendKeys(number);
    }

    public void inputNumber2(String number) {
        number2.clear();
        number2.sendKeys(number);
    }

    public void clickCalculateButton() {
        calculateButton.click();
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    public void clickOperationPerformedButton() {
        OperationPerformedButton.click();
    }
}
