import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class REGISTRATION {

    Scanner scanner = new Scanner(System.in);

    public String UserName;
    public String password;
    public String phoneNumber;
    public String FirstName;
    public String LastName;

    public boolean checkUserName(String UserName) {
        return UserName.length()<=5&& UserName.contains("_");
    }
    public boolean checkpassword(String password) {
        if (password.length() <8) {
            return false;
        }
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isLowerCase(c)) {
                hasLower = true;
            } else {
                Pattern specialPat = Pattern.compile("[^a-zA-Z0-9]");
                Matcher specialMat = specialPat.matcher(String.valueOf(c));
                if (specialMat.find()) {
                    hasSpecial = true;
                }
            }
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

    public boolean checkphoneNumber(String phoneNumber) {
        return phoneNumber.matches("(\\+27|0)[0-9]{9}");
    }
    public void Register() {
        while (true) {
            System.out.println("Enter your Firstname ");
            FirstName = scanner.nextLine();

            if (FirstName != null) {
                System.out.println("Firstname is valid.");
                break;
            } else {System.out.println("Invalid, Your Firstname cannot be empty.");
            }// ends here
        }

        //user must enter Last name
        while (true) {
            System.out.println("Enter your Lastname");
            LastName = scanner.nextLine();

            if (LastName != null) {
                System.out.println("LastName is valid.");
                break;
            } else {System.out.println("Invalid, Your Lastname cannot be empty.");
            }// ends here
        }

        //user must enter Username
        while (true) {
            System.out.println("Enter your username (Must contain '_' and not be more than 5 characters):");
            UserName = scanner.nextLine();

            if (UserName.contains("_") && UserName.length() <= 5) {
                System.out.println("Username successfully captured");
                break;
            } else {
                System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
            }// ends here
        }

        // User must enter password
        while (true) {
            System.out.println("Enter your password (must be 8 characters, a capital letter, at least one number, a special character):");
            password = scanner.nextLine();

            if (checkpassword(password)) {
                System.out.println("Password successfully captured.");
                break;
            } else {
                System.out.println("Password is not correctly formatted;please ensure that the password contains at least eight characters,a capital letter,a number,and a special character.");
            }// ends here
        }

        // User must enter phone number
        while (true) {
            System.out.println("Enter your phone number (must contain international country code, 10 numbers):");
            phoneNumber = scanner.nextLine();

            if (checkphoneNumber(phoneNumber)) {
                System.out.println("Phone number successfully added .");
                break;
            } else {
                System.out.println("Phone number incorrectly formatted or does not contain international code .");
            }
        }
    }

}
