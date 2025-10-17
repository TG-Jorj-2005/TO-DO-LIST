package model;

import java.time.LocalDateTime;

public class Task {
  private int id;
  private LocalDateTime data_creare;
  private String title;
  private String detail;
  private LocalDateTime deadline;
  private boolean completed;

  public Task() {
    id++;
    data_creare = LocalDateTime.now();
    title = "";
    detail = "";
    completed = false;
    deadline = null;
  }

  public Task(String title, String detail, boolean completed, LocalDateTime deadline) {
    this.title = title;
    this.detail = detail;
    this.completed = completed;
    id++;
    data_creare = LocalDateTime.now();
    this.deadline = deadline;
  }

  // getters and setters

  public int getId() {
    return id;
  }

  public LocalDateTime getData_creare() {
    return data_creare;
  }

  public void setData_creare(LocalDateTime data_creare) {
    this.data_creare = data_creare;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public boolean isCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

  public LocalDateTime getDeadline() {
    return deadline;
  }

  public void setDeadline(LocalDateTime deadline) {
    this.deadline = deadline;
  }
}
