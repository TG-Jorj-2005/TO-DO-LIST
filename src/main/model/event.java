package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class event {
  private UUID id;
  private LocalDateTime data_creare;
  private String title_and_detail;
  private LocalDateTime deadline;
  private boolean completed;
  private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

  public event() {
    id = UUID.randomUUID();
    data_creare = LocalDateTime.now();
    title_and_detail = "";
    completed = false;
    deadline = null;
  }

  public event(String title_and_detail, boolean completed, LocalDateTime deadline) {
    this.title_and_detail = title_and_detail;
    this.completed = completed;
    id = UUID.randomUUID();
    data_creare = LocalDateTime.now();
    this.deadline = deadline;
  }

  // getters and setters

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public LocalDateTime getData_creare() {
    return data_creare;
  }

  public void setData_creare(LocalDateTime data_creare) {
    this.data_creare = data_creare;
  }

  public String getTitle_and_detail() {
    return title_and_detail;
  }

  public void setTitle_and_detail(String title_and_detail) {
    this.title_and_detail = title_and_detail;
  }

  public LocalDateTime getDeadline() {
    return deadline;
  }

  public void setDeadline(LocalDateTime deadline) {
    this.deadline = deadline;
  }

  public boolean isCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }
}
