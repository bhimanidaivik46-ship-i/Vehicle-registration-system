import java.util.Scanner;
import java.util.Random;

class PasswordUtil {

    static String generatePassword() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#";
        Random r = new Random();
        String pass = "";

        for (int i = 0; i < 6; i++) {   // 6 digit password
            pass = pass + chars.charAt(r.nextInt(chars.length()));
        }
        return pass;
    }
}
class UserLoginSystem {

    static String username;
    static String password;   // generated password

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Username input
        System.out.print("Enter Username : ");
        username = sc.nextLine();

        // Auto-generate password
        password = PasswordUtil.generatePassword();

        System.out.println("Generated Password (save it): " + password);

        System.out.println("\n------ LOGIN ------");

        // Login input
        System.out.print("Enter Username : ");
        String u = sc.nextLine();

        System.out.print("Enter Password : ");
        String p = sc.nextLine();

        // Authentication
        if (u.equals(username) && p.equals(password)) {
            System.out.println(" LOGIN SUCCESSFUL");
        } else {
            System.out.println(" LOGIN FAILED");
        }
    }
}
