package TypeNote;

import java.time.LocalDateTime;

public class Note {
  private String titlu;
  private String descriere;
  private LocalDateTime data;

  public Note() {
    titlu = "";
    descriere = "";
    data = LocalDateTime.now();
  }

  public Note(String titlu, String descri) {
    this.titlu = titlu;
    descriere = descri;
    data = LocalDateTime.now();
  }

  public String getTitlu() {
    return titlu;
  }

  public String getDescriere() {
    return descriere;
  }

  public LocalDateTime getData() {
    return data;
  }

  // Setteri
  public void setTitlu(String titlu) {
    this.titlu = titlu;
  }

  public void setDescriere(String descriere) {
    this.descriere = descriere;
  }

  public void setData(LocalDateTime data) {
    this.data = data;
  }
}
