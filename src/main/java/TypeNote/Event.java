package TypeNote;

import java.time.LocalDateTime;

public class Event {
  private LocalDateTime setData;
  private String title;
  private String miniDescriere;
  private boolean finalizat;

  public Event() {
    setData = LocalDateTime.now();
    title = "";
    miniDescriere = "";
    finalizat = false;
  }

  public Event(String title, String descriere, boolean finalizat) {
    this.title = title;
    this.miniDescriere = descriere;
    this.finalizat = finalizat;
    setData = LocalDateTime.now();
  }

  // Getteri
  public LocalDateTime getSetData() {
    return setData;
  }

  public String getTitle() {
    return title;
  }

  public String getMiniDescriere() {
    return miniDescriere;
  }

  public boolean isFinalizat() {
    return finalizat;
  }

  // Setteri
  public void setSetData(LocalDateTime setData) {
    this.setData = setData;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setMiniDescriere(String miniDescriere) {
    this.miniDescriere = miniDescriere;
  }

  public void setFinalizat(boolean finalizat) {
    this.finalizat = finalizat;
  }
}
