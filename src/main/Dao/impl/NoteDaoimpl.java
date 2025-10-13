package Dao.impl;

import Dao.NoteDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Note;

public class NoteDaoimpl implements NoteDao {

  private Connection connection;

  public NoteDaoimpl(Connection connection) {
    this.connection = connection;
  }

  @Override
  public void addNote(Note note) {
    String sql = "INSERT INTO Note (name, date, location) VALUES (?, ?, ?)";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
      pstmt.setString(1, note.getContent());
      pstmt.setDate(2, note.getData_creare());
      pstmt.setInt(3, note.getId());
      pstmt.setBoolean(4, note.isCompleted());
      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
