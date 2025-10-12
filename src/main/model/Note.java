package model;

import java.time.LocalDateTime;

public class Note {
  private static int id;
  private LocalDateTime data_creare;
  private String content;
  private static final int MAX_LENGTH = 1000;

  public Note() {
    id++;
    data_creare = LocalDateTime.now();
    content = "";
  }

  public Note(String content) {
    if (content.length() > MAX_LENGTH) {
      throw new IllegalArgumentException(
          "Content exceeds maximum length of " + MAX_LENGTH + " characters.");
    }
    this.content = content;
    id++;
    data_creare = LocalDateTime.now();
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

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    if (content.length() > MAX_LENGTH) {
      throw new IllegalArgumentException(
          "Content exceeds maximum length of " + MAX_LENGTH + " characters");
    }
    this.content = content;
  }
}
