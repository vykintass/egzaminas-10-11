package lt.techin.vd;

import org.checkerframework.common.reflection.qual.ForName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditPage extends BasePage {
    public EditPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[name] p:nth-child(4) [type]")
    private WebElement secondNumberField;
    @FindBy(css = "[type='submit']")
    private WebElement submitButton;
    @FindBy(css = "tr:nth-of-type(4) > td:nth-of-type(2)")
    private WebElement editedSecondNumberField;
    @FindBy(css = "h1")
    private WebElement titleField;

    public void editSecondNumberField(String number) {
        secondNumberField.clear();
        secondNumberField.sendKeys(number);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public String getEditedSecondNumberText() {
        return editedSecondNumberField.getText();
    }

    public String getErrorTitleText() {
        return titleField.getText();
    }
}
