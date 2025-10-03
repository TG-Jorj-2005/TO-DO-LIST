import java.time.LocalDateTime;
import java.util.UUID;

enum Priority {
  LOW,
  MEDIUM,
  HIGH
}

public class Task {
  private UUID id;
  private String title;
  private String description;
  private boolean isCompleted;
  private LocalDateTime dueDate;
  private Priority priority;
  private Category category;

  public Task() {
    this.id = UUID.randomUUID();
    this.isCompleted = false;
  }

  public Task(
      String title,
      String description,
      LocalDateTime dueDate,
      Priority priority,
      Category category) {
    this.id = UUID.randomUUID();
    this.title = title;
    this.description = description;
    this.isCompleted = false;
    this.dueDate = dueDate;
    this.priority = priority;
    this.category = category;
  }

  // Getters and Setters

  // Getters

  public UUID getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public boolean getIsCompleted() {
    return isCompleted;
  }

  public LocalDateTime getDueDate() {
    return dueDate;
  }

  public Priority getPriority() {
    return priority;
  }

  public Category getCategory() {
    return category;
  }

  // Setters

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setIsCompleted(boolean isCompleted) {
    this.isCompleted = isCompleted;
  }

  public void setDueDate(LocalDateTime dueDate) {
    this.dueDate = dueDate;
  }

  public void setPriority(Priority priority) {
    this.priority = priority;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  // Util methods
  public void toggleCompletion() {
    this.isCompleted = !this.isCompleted; // inversează direct
  }

  public boolean isOverdue() {

    return this.dueDate != null && this.dueDate.isBefore(LocalDateTime.now());
  }

  public String toString() {
    return "Task ID: "
        + id.toString()
        + "\n"
        + "Title: "
        + title
        + "\n"
        + "Description: "
        + description
        + "\n"
        + "Completed: "
        + isCompleted
        + "\n"
        + "Due Date: "
        + dueDate.toString()
        + "\n"
        + "Priority: "
        + priority.toString()
        + "\n"
        + "Category: "
        + (category != null ? category.getTitle() : "None")
        + "\n";
  }

  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Task task = (Task) obj;
    return id.equals(task.id);
  }

  public int hashCode() {
    return id.hashCode();
  }
}
