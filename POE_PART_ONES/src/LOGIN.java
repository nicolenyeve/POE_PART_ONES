import java.util.Scanner;

public class LOGIN {
    private String UserName;
    private String password;
    private String firstName;
    private String lastName;

    // Constructor
    public LOGIN(String UserName, String password, String firstName, String lastName) {
        this.UserName = UserName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Method to attempt login
    public String loginUser(String enteredUserName, String enteredPassword) {


        if (enteredUserName.equals(UserName) && enteredPassword.equals(password)) {
            System.out.println("Welcome back " + this.firstName + " " + this.lastName + "! It's great to see you again.");
            return "Login successful for: " + firstName;
        }


        Scanner scanner = new Scanner(System.in);
        boolean loginSuccess = false;

        while (!loginSuccess) {
            System.out.println("Incorrect username or password. Please try again.");
            System.out.print("Please re-enter your username: ");
            enteredUserName = scanner.nextLine();
            System.out.print("Please re-enter your password: ");
            enteredPassword = scanner.nextLine();

            if (enteredUserName.equals(UserName) && enteredPassword.equals(password)) {
                System.out.println("Welcome back " + this.firstName + " " + this.lastName + "! It's great to see you again.");
                loginSuccess = true;
            }
        }

        return "Login successful for: " + firstName;
    }
}
