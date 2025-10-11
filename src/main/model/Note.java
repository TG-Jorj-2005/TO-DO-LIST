package model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Note {
  private UUID id;
  private LocalDateTime data_creare;
  private String content;
  private static final int MAX_LENGTH = 1000;

  public Note() {
    id = UUID.randomUUID();
    data_creare = LocalDateTime.now();
    content = "";
  }

  public Note(String content) {
    if (content.length() > MAX_LENGTH) {
      throw new IllegalArgumentException(
          "Content exceeds maximum length of " + MAX_LENGTH + " characters.");
    }
    this.content = content;
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
