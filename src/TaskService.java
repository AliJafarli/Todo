import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private List<UserTask> tasks = new ArrayList<>();

    public String addTask(String taskName, String dueDate, String priority) {
        String validationMessage = validateTask(taskName, dueDate, priority);
        if (!validationMessage.isEmpty()) {
            return validationMessage;
        }

        LocalDate date = LocalDate.parse(dueDate, DATE_FORMATTER);
        Priority taskPriority = Priority.valueOf(priority.toUpperCase());
        UserTask task = new UserTask(taskName, date, taskPriority);
        tasks.add(task);
        return "Task added successfully.";
    }

    public String updateTaskStatus(int taskId, String newStatus) {
        for (UserTask userTask : tasks) {
            if (userTask.getTaskId() == taskId) {
                if (!isValidStatus(newStatus)) {
                    return "Invalid status. Status must be 'Pending', 'In Progress', or 'Completed'.";
                }

                userTask.setTaskStatus(TaskStatus.valueOf(newStatus.toUpperCase()));
                return "Task status updated successfully.";
            }
        }
        return "Task not found.";
    }

    private String validateTask(String name, String dueDate, String priority) {
        if (name == null || name.isEmpty() || dueDate == null || dueDate.isEmpty() || priority == null || priority.isEmpty()) {
            return "All fields are required.";
        }

        try {
            LocalDate.parse(dueDate, DATE_FORMATTER);
        } catch (DateTimeParseException e) {
            return "Due date must be in the format YYYY-MM-DD.";
        }

        try {
            Priority.valueOf(priority.toUpperCase());
        } catch (IllegalArgumentException e) {
            return "Priority must be Low, Medium, or High.";
        }

        return "";
    }

    private boolean isValidStatus(String status) {
        try {
            TaskStatus.valueOf(status.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public void printTasks() {
        for (UserTask userTask : tasks) {
            System.out.println(userTask);
        }
    }
}
