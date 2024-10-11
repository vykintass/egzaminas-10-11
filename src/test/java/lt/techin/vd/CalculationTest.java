package lt.techin.vd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculationTest extends BaseTest {
    @Test
    public void calculationTestPositive() {
        //create user
        loginPage.clickCreateNewAccountLink();
        registrationPage.inputUsername();
        registrationPage.inputPassword();
        registrationPage.inputPasswordConfirm();
        registrationPage.clickSubmitButton();
        //Calculation
        calculatorPage.inputNumber1("4");
        calculatorPage.inputNumber2("5");
        calculatorPage.clickCalculateButton();
        //Check if calculation was correct
        Assertions.assertTrue(operationsPerformedPage.calculationMade().contains("9"), "Calculation failed");
    }

    @Test
    public void calculationTestNegative() {
        //create user
        loginPage.clickCreateNewAccountLink();
        registrationPage.inputUsername();
        registrationPage.inputPassword();
        registrationPage.inputPasswordConfirm();
        registrationPage.clickSubmitButton();
        //Calculation
        calculatorPage.inputNumber1("4");
        calculatorPage.inputNumber2("-1");
        calculatorPage.clickCalculateButton();
        //Check if there is an error message
        Assertions.assertTrue(calculatorPage.getErrorMessageText().contains("klaida"), "Calculation was successful");
    }
}
