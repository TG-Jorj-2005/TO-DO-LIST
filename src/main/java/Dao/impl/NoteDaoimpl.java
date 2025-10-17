package Dao.impl;

import Dao.NoteDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Note;

public class NoteDaoimpl implements NoteDao {

  private Connection connection;

  public NoteDaoimpl(Connection connection) {
    this.connection = connection;
  }

  private void validateNote(Note n) throws Exception {
    if (n.getContent() == null || n.getContent().isEmpty()) {
      throw new Exception("Note content cannot be null or empty");
    }
    if (n.getData_creare() == null) {
      throw new Exception("Note date cannot be null");
    }
    if (n.getId() <= 0) {
      throw new Exception("Note ID must be a positive integer");
    }
    // Add more validation rules as needed
  }

  @Override
  public void addNote(Note note) {
    validateNote(note);
    String sql = "INSERT INTO Note (content, data_creare, completed) VALUES (?, ?, ?)";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
      pstmt.setString(1, note.getContent());
      pstmt.setDate(2, note.getData_creare());
      pstmt.setBoolean(3, note.isCompleted());
      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void deleteNote(int Noteid) {
    String sql = "DElete INTO NOTE (Name,date,location) (?,?,?)";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
      pstmt.setInt(1, Noteid);
      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Note getNotebyId(int Noteid) {
    String sql = "SELECT * FROM Note WHERE id = ?";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
      pstmt.setInt(1, Noteid);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        String content = rs.getString("content");
        Date data_creare = rs.getDate("data_creare");
        int id = rs.getInt("id");
        boolean completed = rs.getBoolean("completed");
        return new Note(content, data_creare, id, completed);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public void updateNote(Note note) {
    validateNote(note);
    String sql = "UPDATE Note SET contetn = ?, data_creare = ?, id = ?, completed =? WHERE id = ?";
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

  @Override
  public List<Note> getAllNote() {
    List<Note> notes = new ArrayList<>();
    String sql = "SELECT * FROM Note";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        String content = rs.getString("content");
        Date data_creare = rs.getDate("data_creare");
        int id = rs.getInt("id");
        boolean completed = rs.getBoolean("completed");
        notes.add(new Note(content, data_creare, id, completed));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return notes;
  }
}
