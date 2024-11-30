import java.util.Scanner;

public class Main {


    private static UserService userService = new UserService();
    private static TaskService taskService = new TaskService();
    private static Scanner scanner = new Scanner(System.in);
    private static String loggedInEmail = null;

    public static void main(String[] args) {
        while (true) {
            if (loggedInEmail == null) {
                showLoginMenu();
            } else {
                showMainMenu();
            }
        }
    }

    private static void showLoginMenu() {
        System.out.println("Welcome to TODO App!");
        System.out.println("1. Create an Account");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                createAccount();
                break;
            case 2:
                login();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private static void showMainMenu() {
        System.out.println("1. Add TODO");
        System.out.println("2. View TODOs");
        System.out.println("3. Update Task Status");
        System.out.println("4. Delete Task");
        System.out.println("5. Logout");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                addTodo();
                break;
            case 2:
                viewTodos();
                break;
            case 3:
                updateTaskStatus();
                break;
            case 4:
                deleteTask();
                break;
            case 5:
                loggedInEmail = null;
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private static void createAccount() {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        String result = userService.createAccount(email, password);
        System.out.println(result);
    }

    private static void login() {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        User user = new User(email,password);
        if (user != null && user.getPassword().equals(password)) {
            loggedInEmail = email;
            System.out.println("Login successful.");
        } else {
            System.out.println("Invalid email or password.");
        }
    }

    private static void addTodo() {
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();
        System.out.print("Enter due date (YYYY-MM-DD): ");
        String dueDate = scanner.nextLine();
        System.out.print("Enter priority (Low, Medium, High): ");
        String priority = scanner.nextLine();
        String result = taskService.addTask(name, dueDate, priority);
        System.out.println(result);
    }

    private static void viewTodos() {
        taskService.printTasks();
    }

    private static void updateTaskStatus() {
        System.out.print("Enter task ID: ");
        int taskId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new status (Pending, In Progress, Completed): ");
        String newStatus = scanner.nextLine();
        String result = taskService.updateTaskStatus(taskId, newStatus);
        System.out.println(result);
    }

    private static void deleteTask() {
        System.out.print("Enter task ID: ");
        int taskId = scanner.nextInt();

    }
}