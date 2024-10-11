package lt.techin.vd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculationEditTest extends BaseTest {
    @Test
    public void calculationEditPositive() {
        //create user
        loginPage.clickCreateNewAccountLink();
        registrationPage.inputUsername();
        registrationPage.inputPassword();
        registrationPage.inputPasswordConfirm();
        registrationPage.clickSubmitButton();
        calculatorPage.inputNumber1("4");
        calculatorPage.inputNumber2("5");
        calculatorPage.clickCalculateButton();
        operationsPerformedPage.clickCalculatorButton();
        calculatorPage.clickOperationPerformedButton();
        //Click edit
        operationsPerformedPage.clickEditCalculation();
        editPage.editSecondNumberField("10");
        editPage.clickSubmitButton();
        //Check if number is updated
        Assertions.assertEquals("10", editPage.getEditedSecondNumberText(), "Edit was not successful");
    }

    @Test
    public void calculationEditNegative() {
        //create user
        loginPage.clickCreateNewAccountLink();
        registrationPage.inputUsername();
        registrationPage.inputPassword();
        registrationPage.inputPasswordConfirm();
        registrationPage.clickSubmitButton();
        calculatorPage.inputNumber1("4");
        calculatorPage.inputNumber2("5");
        calculatorPage.clickCalculateButton();
        operationsPerformedPage.clickCalculatorButton();
        calculatorPage.clickOperationPerformedButton();
        //Click edit
        operationsPerformedPage.clickEditCalculation();
        editPage.editSecondNumberField("-1");
        editPage.clickSubmitButton();
        //Check if error is displayed
        Assertions.assertTrue(editPage.getErrorTitleText().contains("Error"), "Edit was successful");
    }
}
