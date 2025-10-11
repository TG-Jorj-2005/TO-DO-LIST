package model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Task {
  private UUID id;
  private LocalDateTime data_creare;
  private String title;
  private String detail;
  private boolean completed;

  public Task() {
    id = UUID.randomUUID();
    data_creare = LocalDateTime.now();
    title = "";
    detail = "";
    completed = false;
  }

  public Task(String title, String detail, boolean completed) {
    this.title = title;
    this.detail = detail;
    this.completed = completed;
    id = UUID.randomUUID();
    data_creare = LocalDateTime.now();
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
}
