package Dao.impl;

import Dao.eventDao;
import java.sql.*;
import java.util.*;
import model.event;

public class eventDaoimpl implements eventDao {

  private Connection connection;

  public eventDaoimpl(Connection connection) {
    this.connection = connection;
  }

  private void validateEvent(event e) throws Exception {
    if (e.getTitle_and_detail() == null || e.getTitle_and_detail().isEmpty()) {
      throw new Exception("Event title cannot be null or empty");
    }
    if (e.getData_creare() == null) {
      throw new Exception("Event date cannot be null");
    }
    if (e.getisCompleted() == null) {
      throw new Exception("Event completion status cannot be null");
    }
    if (e.getId() <= 0) {
      throw new Exception("Event ID must be a positive integer");
    }
    // Add more validation rules as needed
  }

  @Override
  public void addevent(event event) {
    validateEvent(event);
    String sql = "INSERT INTO events (name, date, location,completed) VALUES (?, ?, ?,?)";
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

  @Override
  public void deleteEvent(int eventId) {
    String sql = "DELETE FROM events WHERE id = ?";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
      pstmt.setInt(1, eventId);
      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
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

  @Override
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

  @Override
  public void updateEvent(event event) {
    validateEvent(event);
    String sql = "UPDATE events SET name = ?, date = ?, location = ?,completed = ?, WHERE id = ?";
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
