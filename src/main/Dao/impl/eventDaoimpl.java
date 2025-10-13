package Dao.impl;

import java.sql.*;
import java.util.*;
import model.event;

public class eventDaoimpl extends eventDao {

  private Connection connection;

  public eventDaoimpl(Connection connection) {
    this.connection = connection;
  }

  public void addevent(event event) {
    String sql = "INSERT INTO events (name, date, location) VALUES (?, ?, ?)";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
      pstmt.setString(1, event.getTitle_and_detail());
      pstmt.setDate(2, event.getData_creare());
      pstmt.setInt(3, event.getId());
      pstmt.setBoolean(4, event.isCompleted());
      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void deleteEvent(int eventId) {
    String sql = "DELETE FROM events WHERE id = ?";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
      pstmt.setInt(1, eventId);
      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public event getEventById(int eventId) {
    String sql = "SELECT * FROM events WHERE id = ?";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
      pstmt.setInt(1, eventId);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        return new event();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public List<event> getAllEvents() {
    List<event> events = new ArrayList<>();
    String sql = "SELECT * FROM events";
    try (Statement stmt = connection.createStatement()) {
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        events.add(new event());
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return events;
  }

  public void updateEvent(event event) {
    String sql = "UPDATE events SET name = ?, date = ?, location = ? WHERE id = ?";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
      pstmt.setString(1, event.getTitle_and_detail());
      pstmt.setDate(2, event.getData_creare());
      pstmt.setInt(3, event.getId());
      pstmt.setBoolean(4, event.isCompleted());
      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
