package lt.techin.vd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "passwordConfirm")
    private WebElement passwordConfirmField;
    @FindBy(css = "button")
    private WebElement submitButton;
    @FindBy(id = "passwordConfirm.errors")
    private WebElement errorsField;

    private String randomPassword;
    private String generatedUsername;
    private String generatedPassword;

    public String generateUsername() {
        Random random = new Random();
        int randomNumber = random.nextInt(9000) + 1000;
        this.generatedUsername = "Test" + randomNumber;
        return generatedUsername;
    }

    public String generatePassword() {
        Random random = new Random();
        int randomNumber = random.nextInt(9000) + 1000;
        this.generatedPassword = "Test" + randomNumber + "!";
        return generatedPassword;
    }

    public String getGeneratedUsername() {
        return generatedUsername;
    }

    public String getGeneratedPassword() {
        return generatedPassword;
    }

    public void inputUsername() {
        String randomUsername = generateUsername();
        usernameField.sendKeys(randomUsername);
    }

    public void inputPassword() {
        randomPassword = generatePassword();
        passwordField.sendKeys(randomPassword);
    }

    public void inputPasswordConfirm() {
        passwordConfirmField.sendKeys(randomPassword);
    }

    public void inputNotMatchingPassword() {
        String randomPasswordNew = generatePassword();
        passwordConfirmField.sendKeys(randomPasswordNew);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public String getErrorsFieldText() {
        return errorsField.getText();
    }
}
