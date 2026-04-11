import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class RegistrationTest {
    @Test
    public void testUsernameCorrectlyFormatted() {
        REGISTRATION registration = new REGISTRATION();
        String testUsername = "kyl_1";
        // username correctly formatted
        boolean result = registration.checkUserName(testUsername);
        assertTrue(result);  // Expected: True
    }

    // Username Incorrectly Formatted Test
    @Test
    public void testUsernameIncorrectlyFormatted() {
        REGISTRATION registration = new REGISTRATION();
        String testUsername = "kyle!!!!!!!";
        // username incorrectly formatted
        boolean result = registration.checkUserName(testUsername);
        assertFalse(result);
        // Expected: False
    }

    // Password Meets Complexity Test
    @Test
    public void testPasswordMeetsComplexityRequirements() {
        REGISTRATION registration = new REGISTRATION();
        String testPassword = "Ch&&sec@ke99!";
        // password meets complexity requirements
        boolean result = registration.checkpassword(testPassword);
        assertTrue(result);  // Expected: True
    }


    // Password Does Not Meet Complexity Test
    @Test
    public void testPasswordDoesNotMeetComplexityRequirements() {
        REGISTRATION registration = new REGISTRATION();
        String testPassword = "password";
        // password does not meet complexity requirements
        boolean result = registration.checkpassword(testPassword);
        assertFalse(result);
        // Expected: False
    }

    // Cell Phone Number Correctly Formatted Test
    @Test
    public void testPhoneNumberCorrectlyFormatted() {
        REGISTRATION registration = new REGISTRATION();
        String testPhoneNumber = "+27838968976";  // phone number is correctly formatted
        boolean result = registration.checkphoneNumber(testPhoneNumber);
        assertTrue(result);  // Expected: True
    }

    // Cell Phone Number Incorrectly Formatted Test
    @Test
    public void testPhoneNumberIncorrectlyFormatted() {
        REGISTRATION registration = new REGISTRATION();
        String testPhoneNumber = "08966553";
        // phone number incorrectly formatted
        boolean result = registration.checkphoneNumber(testPhoneNumber);
        assertFalse(result);
        // Expected: False
    }
}