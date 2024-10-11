package lt.techin.vd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OperationsPerformedPage extends BasePage {

    public OperationsPerformedPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h4")
    public WebElement calculationMade;
    @FindBy(linkText = "Skaičiuotuvas")
    public WebElement clickCalculatorButton;

    @FindBy(css = "tbody  td:nth-of-type(4)")
    public List<WebElement> calculations;
    @FindBy(css = "tr:nth-of-type(2) > td:nth-of-type(5) > a:nth-of-type(1)")
    public WebElement editCalculation;


    public String calculationMade() {
        return calculationMade.getText();
    }

    public void clickCalculatorButton() {
        clickCalculatorButton.click();
    }

    public String getCalculations() {
        for (WebElement calculation : calculations) {
            String calculationText = calculation.getText().trim();
            //Check if equal to 50
            if (calculationText.equals("50")) {
                return calculationText;
            }
        }
        return null;
    }

    public void clickEditCalculation() {
        editCalculation.click();
    }
}


