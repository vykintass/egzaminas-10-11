package lt.techin.vd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Sukurti naują paskyrą")
    private WebElement createNewAccountLink;
    @FindBy(css="input[name='username']")
    private WebElement username;
    @FindBy(css="input[name='password']")
    private WebElement password;
    @FindBy(css=".btn.btn-block.btn-lg.btn-primary")
    private WebElement loginButton;
    @FindBy(css="div > span:nth-of-type(2)")
    private WebElement loginErrorMessage;
    public void clickCreateNewAccountLink() {
        createNewAccountLink.click();
    }
    public void inputUsername(String username) {
        this.username.sendKeys(username);
    }
    public void inputPassword(String password) {
        this.password.sendKeys(password);
    }
    public void clickLoginButton() {
        loginButton.click();
    }
    public String getLoginErrorMessage() {
        return loginErrorMessage.getText();
    }
}
