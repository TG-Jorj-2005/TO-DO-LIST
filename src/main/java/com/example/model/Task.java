package com.example.model;

import java.time.LocalDate;

public class Task {
  private int id;
  private String title;
  private String detail;
  private boolean completed;
  private LocalDate deadline;

  public Task() {}

  public Task(int id, String title, String detail, boolean completed, LocalDate deadline) {
    this.id = id;
    this.title = title;
    this.detail = detail;
    this.completed = completed;
    this.deadline = deadline;
  }

  public Task(String title, String detail, boolean completed, LocalDate deadline) {
    this.title = title;
    this.detail = detail;
    this.completed = completed;
    this.deadline = deadline;
  }

  // Getteri și setteri
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

  public LocalDate getDeadline() {
    return deadline;
  }

  public void setDeadline(LocalDate deadline) {
    this.deadline = deadline;
  }
}
