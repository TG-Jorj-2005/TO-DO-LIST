package TypeNote;

import java.time.LocalDateTime;
import java.util.UUID;

public class Task {
  private LocalDateTime creare;
  private UUID id;
  private String title;
  private String descriere;
  private boolean finalizat;

  public Task() {
    creare = LocalDateTime.now();
    id = UUID.randomUUID();
    title = "";
    descriere = "";
    finalizat = false;
  }

  public Task(String title, String descriere, boolean finalizat) {
    this.title = title;
    this.descriere = descriere;
    this.finalizat = finalizat;
  }

  // Getteri
  public LocalDateTime getTimp() {
    return creare;
  }

  public UUID getId() {
    return id;
  }

  public String getTitlu() {
    return title;
  }

  public String getDescriere() {
    return descriere;
  }

  public boolean getFinalizat() {
    return finalizat;
  }

  // Setteri

  public void setLocalDateTime(LocalDateTime timp) {
    timp = LocalDateTime.now();
    creare = timp;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public void setTitlu(String titlu) {
    this.title = titlu;
  }

  public void setDescriere(String descri) {
    descriere = descri;
  }

  public void setFinalizat(boolean fin) {
    finalizat = fin;
  }
}
