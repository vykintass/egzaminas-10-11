package lt.techin.vd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculationSearchTest extends BaseTest {
    @Test
    public void calculationSearchPositive() {
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
        //navigate to the calculator and make a unique calculation
        operationsPerformedPage.clickCalculatorButton();
        calculatorPage.inputNumber1("20");
        calculatorPage.inputNumber2("30");
        calculatorPage.clickCalculateButton();
        //navigate to the calculator
        operationsPerformedPage.clickCalculatorButton();
        calculatorPage.clickOperationPerformedButton();
        //Save expected value
        String expectedResult = operationsPerformedPage.getCalculations();
        //Check if there is a number 50
        Assertions.assertEquals("50", operationsPerformedPage.getCalculations(), "Incorrect");
    }

    @Test
    public void calculationSearchNegative() {
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
        //navigate to the calculator and make a unique calculation
        operationsPerformedPage.clickCalculatorButton();
        calculatorPage.inputNumber1("20");
        calculatorPage.inputNumber2("30");
        calculatorPage.clickCalculateButton();
        //navigate to the calculator
        operationsPerformedPage.clickCalculatorButton();
        calculatorPage.clickOperationPerformedButton();
        //Save expected value
        String expectedResult = operationsPerformedPage.getCalculations();
        //Check if there is a number 60
        Assertions.assertFalse(operationsPerformedPage.getCalculations().contains("60"), "correct");
    }
}
