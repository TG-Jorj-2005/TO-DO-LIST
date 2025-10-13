package Dao.impl;

import Dao.TaskDao;
import java.sql.*;
import java.util.*;
import model.Task;

public class TaskDaoimpl implements TaskDao {
  private Connection connection;

  public TaskDaoimpl(Connection conect) {
    this.connection = conect;
  }

  @Override
  public addTask(Task task) {
    String sql =
        "INSERT INTO Task (id, title, data_creare, detail ,completed,deadline) VALUES (?, ?,"
            + " ?,?,?)";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
      pstmt.setInt(1, task.getId());
      pstmt.setString(2, task.getTitle());
      pstmt.setDate(3, Date.valueOf(task.getData_creare().toLocalDate()));
      pstmt.setString(4, task.getDetail());
      pstmt.setBoolean(5, task.isCompleted());
      pstmt.setDate(6, Date.valueOf(task.getDeadline().toLocalDate()));

      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void deleteTask(int taskId) {
    String sql = "DELETE FROM Task WHERE id = ?";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
      pstmt.setInt(1, taskId);
      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Task getTaskById(int taksId) {
    string sql = "SELECT * FROM Task WHERE id = ?";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
      pstmt.setInt(1, taksId);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        String title_and_detail = rs.getString("title_and_detail");
        Date data_creare = rs.getDate("data_creare");
        int id = rs.getInt("id");
        boolean completed = rs.getBoolean("completed");
        return new Task(title_and_detail, data_creare, id, completed);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void updateTask(Task taks) {
    String sql =
        "UPDATE Task SET id = ?,title = ?, data_creare = ?, detail = ? ,completed = ?, Date = ?"
            + " ,WHERE id = ?";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
      pstmt.setInt(1, task.getId());
      pstmt.setString(2, task.getTitle());
      pstmt.setDate(3, Date.valueOf(task.getData_creare().toLocalDate()));
      pstmt.setString(4, task.getDetail());
      pstmt.setBoolean(5, task.isCompleted());
      pstmt.setDate(6, Date.valueOf(task.getDeadline().toLocalDate()));
      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<Task> getAllTasks() {
    List<Task> tasks = new ArrayList<>();
    String sql = "SELECT * FROM Task";
    try (Statement stmt = connection.createStatement()) {
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        tasks.add(
            new Task(
                rs.getString("title"),
                rs.getString("detail"),
                rs.getBoolean("completed"),
                rs.getDate("deadline").toLocalDate().atStartOfDay()));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
