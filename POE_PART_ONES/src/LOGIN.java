import java.util.Scanner;

public class LOGIN {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private static final int MAX_ATTEMPTS = 3;

    // Constructor
    public LOGIN(String userName, String password, String firstName, String lastName) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Method to attempt login with retry limit
    public String loginUser(String enteredUserName, String enteredPassword) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 1;

        // Check first attempt
        if (enteredUserName.equals(userName) && enteredPassword.equals(password)) {
            System.out.println("Welcome back " + this.firstName + " " + this.lastName + "! It's great to see you again.");
            MessageApp.startChat();
            return "Login successful for: " + firstName;
        }

        // Retry up to MAX_ATTEMPTS - 1 more times
        while (attempts < MAX_ATTEMPTS) {
            System.out.println("Incorrect username or password. Attempt " + attempts + " of " + MAX_ATTEMPTS);
            System.out.print("Please re-enter your username: ");
            enteredUserName = scanner.nextLine();
            System.out.print("Please re-enter your password: ");
            enteredPassword = scanner.nextLine();

            if (enteredUserName.equals(userName) && enteredPassword.equals(password)) {
                System.out.println("Welcome back " + this.firstName + " " + this.lastName + "! It's great to see you again.");

                return "Login successful for: " + firstName;
            }
            attempts++;
        }

        System.out.println("Too many failed attempts. Access denied.");
        return "Login failed - maximum attempts exceeded";
    }
}
