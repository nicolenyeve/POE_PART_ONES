import org.junit.Test;
import static org.junit.Assert.*;

public class classTest {

    // Registration: Username tests
    @Test
    public void testValidUsername() {
        REGISTRATION reg = new REGISTRATION();
        assertTrue(reg.checkUserName("abc_"));
        // valid: <=5 chars and contains "_"
    }

    @Test
    public void testInvalidUsernameTooLong() {
        REGISTRATION reg = new REGISTRATION();
        assertFalse(reg.checkUserName("abcdef_"));
        // too long
    }

    @Test
    public void testInvalidUsernameNoUnderscore() {
        REGISTRATION reg = new REGISTRATION();
        assertFalse(reg.checkUserName("abcd"));
        // missing "_"
    }

    // Registration: Password tests
    @Test
    public void testValidPassword() {
        REGISTRATION reg = new REGISTRATION();
        assertTrue(reg.checkpassword("Passw0rd!"));
        // has uppercase, digit, special
    }

    @Test
    public void testInvalidPasswordTooShort() {
        REGISTRATION reg = new REGISTRATION();
        assertFalse(reg.checkpassword("Pw1!"));
        // too short
    }

    @Test
    public void testInvalidPasswordNoUppercase() {
        REGISTRATION reg = new REGISTRATION();
        assertFalse(reg.checkpassword("password1!"));
        // no uppercase
    }

    @Test
    public void testInvalidPasswordNoDigit() {
        REGISTRATION reg = new REGISTRATION();
        assertFalse(reg.checkpassword("Password!"));
        // missing digit
    }

    @Test
    public void testInvalidPasswordNoSpecialChar() {
        REGISTRATION reg = new REGISTRATION();
        assertFalse(reg.checkpassword("Password1"));
        // missing special char
    }

    // Registration: Phone number tests
    @Test
    public void testValidPhoneNumberLocal() {
        REGISTRATION reg = new REGISTRATION();
        assertTrue(reg.checkphoneNumber("0123456789"));
        // starts with 0 + 9 digits
    }

    @Test
    public void testValidPhoneNumberInternational() {
        REGISTRATION reg = new REGISTRATION();
        assertTrue(reg.checkphoneNumber("+27123456789"));
        // starts with +27 + 9 digits
    }

    @Test
    public void testInvalidPhoneNumberTooShort() {
        REGISTRATION reg = new REGISTRATION();
        assertFalse(reg.checkphoneNumber("12345"));
        // too short
    }

    @Test
    public void testInvalidPhoneNumberWrongPrefix() {
        REGISTRATION reg = new REGISTRATION();
        assertFalse(reg.checkphoneNumber("9912345678"));
        // wrong prefix
    }

    // Login: Successful login
    @Test
    public void testSuccessfulLogin(){
        LOGIN login= new LOGIN("user123" ,"pass123","john","doe");
        String result =login.loginUser("user123","pass123");
        assertTrue(result.startsWith("Welcome John Doe"));
    }

    //Login : Login Failed
    @Test
    public void testFailedLogin(){
        LOGIN login=new LOGIN("user123","pass123","john","doe");
        String result = login.loginUser("user123","pass123");
        assertFalse(result.startsWith("Invalid user name or password ,Please try again"));
    }
}


