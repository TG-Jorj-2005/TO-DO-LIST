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
    String sql = "INSERT INTO Task (title_and_detail, data_creare, completed) VALUES (?, ?, ?)";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
      pstmt.setString(1, task.getTitle_and_detail());
      pstmt.setDate(2, task.getData_creare());
      pstmt.setBoolean(3, task.isCompleted());
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
  public List<Task> getAllTasks() {
    List<Task> tasks = new ArrayList<>();
    String sql = "SELECT * FROM Task";
    try (Statement stmt = connection.createStatement()) {
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        String title_and_detail = rs.getString("title_and_detail");
        Date data_creare = rs.getDate("data_creare");
        int id = rs.getInt("id");
        boolean completed = rs.getBoolean("completed");
        tasks.add(new Task(title_and_detail, data_creare, id, completed));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
