import java.time.LocalDate;

public class UserTask {
    private static int idCounter = 0;
    private int taskId;
    private User user;
    private String taskName;
    private LocalDate dueDate;
    private Priority priority;
    private TaskStatus taskStatus;

    public UserTask(String taskName, LocalDate dueDate, Priority priority) {
        this.taskId = ++idCounter;
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.priority = priority;
        this.taskStatus = TaskStatus.PENDING;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public String toString() {
        return "Task{id=" + taskId + ", name='" + taskName + "', dueDate=" + dueDate + ", priority=" + priority + ", status=" + taskStatus + "}";
    }
}