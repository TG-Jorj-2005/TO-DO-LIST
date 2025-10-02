public class Task{
 
  private static int idCount=0;
  private int id;
  private String name;
  private String description;
  private boolean Completed;
  private LocalDateTime createdAt; // Format: "YYYY-MM-DDTHH:MM:SS"
  private LocalDate dueDate; // Format: "YYYY-MM-DD"
  private Priority priority; // "Low", "Medium", "High"
  private List<Tag> tags; // List of tags associated with the task
  private List<Subtask> subtasks; // List of subtasks associated with the Subtask

  public Task(String name, String description, LocalDate dueDate, Priority priority) {
    this.id = idCount++;
    this.name = name;
    this.description = description;
    this.Completed = false;
    this.dueDate = dueDate;
    this.priority = priority;
    this.tags = new ArrayList<>();
    this.subtasks = new ArrayList<>();
  } 

  // Getters and Setters

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }
  
  public int getId() {
    return id;
  }
  public void setId(int Id) {
    this.id = Id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public boolean isCompleted() {
    return isCompleted;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }
  
  public Priority getPriority() {
    return priority;
  }

  public List<Tag> getTags() {
    return tags;
  }

  public List<Subtask> getSubtasks() {
    return subtasks;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setCompleted(boolean isCompleted) {
    this.isCompleted = isCompleted;
  }

  public void setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
  }
  
  public void setPriority(Priority priority) {
    this.priority = priority;
  }

  public void addTag(Tag tag) {
    this.tags.add(tag);
  }

  public void removeTag(Tag tag) {
    this.tags.remove(tag);
  }

  public void addSubtask(Subtask subtask) {
    this.subtasks.add(subtask);
  }

  public void removeSubtask(Subtask subtask) {
    this.subtasks.remove(subtask);
  }

  public boolean toogleCompletion(){
    
    this.Completed == true ? this.Completed = false : this.Completed = true;
    return this.Completed;
  }


}
