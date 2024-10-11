package lt.techin.vd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegistrationTest extends BaseTest {

    @Test
    public void testRegistrationPositive() {
        //create user
        loginPage.clickCreateNewAccountLink();
        registrationPage.inputUsername();
        registrationPage.inputPassword();
        registrationPage.inputPasswordConfirm();
        registrationPage.clickSubmitButton();
        //Check if user was logged in
        Assertions.assertTrue(calculatorPage.getLogoutButtonText().contains("Logout"), "User is not logged in");
    }

    @Test
    public void testRegistrationNegative() {
        //create user
        loginPage.clickCreateNewAccountLink();
        registrationPage.inputUsername();
        registrationPage.inputPassword();
        registrationPage.inputNotMatchingPassword();
        registrationPage.clickSubmitButton();
        //Check if error message is displayed
        Assertions.assertTrue(registrationPage.getErrorsFieldText().contains("nesutampa"), "User successfully logged in");
    }

}
