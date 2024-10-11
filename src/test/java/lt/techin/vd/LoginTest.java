package lt.techin.vd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {
    @Test
    public void testLoginPositive() {
        //register user
        loginPage.clickCreateNewAccountLink();
        registrationPage.generateUsername();
        registrationPage.generatePassword();
        //Input data
        registrationPage.inputUsername();
        registrationPage.inputPassword();
        registrationPage.inputPasswordConfirm();
        registrationPage.clickSubmitButton();
        calculatorPage.clickLogoutButton();
        //Start login with same credentials
        String username = registrationPage.getGeneratedUsername();
        String password = registrationPage.getGeneratedPassword();
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();
        //Check if user was logged in
        Assertions.assertTrue(calculatorPage.getLogoutButtonText().contains("Logout"), "User is not logged in");

    }

    @Test
    public void testLoginNegative() {
        //register user
        loginPage.clickCreateNewAccountLink();
        registrationPage.generateUsername();
        registrationPage.generatePassword();
        //Input data
        registrationPage.inputUsername();
        registrationPage.inputPassword();
        registrationPage.inputPasswordConfirm();
        registrationPage.clickSubmitButton();
        calculatorPage.clickLogoutButton();
        //Start login with same credentials
        String username = registrationPage.getGeneratedUsername();
        String password = registrationPage.getGeneratedPassword();
        loginPage.inputUsername(username);
        loginPage.inputPassword("wrongPassword");
        loginPage.clickLoginButton();
        //Check if user was logged in
        Assertions.assertTrue(loginPage.getLoginErrorMessage().contains("yra neteisingi"), "User was logged in");

    }
}
