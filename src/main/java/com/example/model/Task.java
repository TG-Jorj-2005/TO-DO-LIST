package com.example.model;

import java.sql.Date;
import java.time.LocalDate;

public class Task {
  // * Datele membre
  private int id;
  private String title;
  private String detail;
  private boolean completed;
  private Date createDate;
  private Date deadline;

  // * Constructori

  public Task() {
    title = "";
    detail = "";
    completed = false;
    createDate = Date.valueOf(LocalDate.now());
    deadline = Date.valueOf(LocalDate.now());
  }

  public Task(
      int id, String title, String detail, boolean completed, Date createDate, Date deadline) {
    this.id = id;
    this.title = title;
    this.detail = detail;
    this.completed = completed;
    this.createDate = createDate;
    this.deadline = deadline;
  }

  // * Getteri
  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getDetail() {
    return detail;
  }

  public boolean isCompleted() {
    return completed;
  }

  public Date getcreateDate() {
    return createDate;
  }

  public Date getdeadline() {
    return deadline;
  }

  // **Setterri

  public void setId(int id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

  public void setcreateDate(Date create) {
    this.createDate = create;
  }

  public void setdeadline(Date deadline) {
    this.deadline = deadline;
  }
}
