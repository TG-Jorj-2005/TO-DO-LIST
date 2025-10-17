package model;

import java.sql.Date; // atenție, de la java.sql!

public class Task {
  private int id;
  private String title;
  private String detail;
  private boolean completed;
  private Date data_creare;
  private Date deadline;

  public Task() {}

  public Task(
      int id, String title, String detail, boolean completed, Date data_creare, Date deadline) {
    this.id = id;
    this.title = title;
    this.detail = detail;
    this.completed = completed;
    this.data_creare = data_creare;
    this.deadline = deadline;
  }

  // --- Getters și Setters ---
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public Date getData_creare() {
    return data_creare;
  }

  public void setData_creare(Date data_creare) {
    this.data_creare = data_creare;
  }

  public Date getDeadline() {
    return deadline;
  }

  public void setDeadline(Date deadline) {
    this.deadline = deadline;
  }
}
