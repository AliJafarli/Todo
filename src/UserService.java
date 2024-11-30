import java.util.*;

public class UserService {
    private Map<String, User> accounts = new HashMap<>();

    public String createAccount(String email, String password) {
        if (!User.isValidEmail(email)) {
            return "Invalid email format.";
        }
        if (!User.isValidPassword(password)) {
            return "Password must have at least 8 characters, including one uppercase letter, one number, and one special character.";
        }
        if (accounts.containsKey(email)) {
            return "Account already exists.";
        }
        accounts.put(email, new User(email, password));
        return "Account created successfully.";
    }

    public String changePassword(String email, String oldPassword, String newPassword) {
        User user = accounts.get(email);
        if (user == null) {
            return "Account not found.";
        }
        if (!user.getPassword().equals(oldPassword)) {
            return "Old password is incorrect.";
        }
        if (!User.isValidPassword(newPassword)) {
            return "New password must have at least 8 characters, including one uppercase letter, one number, and one special character.";
        }
        user.setPassword(newPassword);
        return "Password updated successfully.";
    }
}
