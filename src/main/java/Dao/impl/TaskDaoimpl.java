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
  public void addTask(Task task) {
    String sql =
        "INSERT INTO Task (id, title, data_creare, detail ,completed,deadline) VALUES (?, ?,"
            + " ?,?,?)";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
      pstmt.setInt(1, task.getId());
      pstmt.setString(2, task.getTitle());
      pstmt.setDate(3, task.getData_creare());
      pstmt.setString(4, task.getDetail());
      pstmt.setBoolean(5, task.isCompleted());
      pstmt.setDate(6, task.getDeadline());

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
    String sql = "SELECT * FROM Task WHERE id = ?";
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
  public void updateTask(Task task) {
    String sql =
        "UPDATE Task SET id = ?,title = ?, data_creare = ?, detail = ? ,completed = ?, Date = ?"
            + " ,WHERE id = ?";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
      pstmt.setInt(1, task.getId());
      pstmt.setString(2, task.getTitle());
      pstmt.setDate(3, task.getData_creare());
      pstmt.setString(4, task.getDetail());
      pstmt.setBoolean(5, task.isCompleted());
      pstmt.setDate(6, task.getDeadline());
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
        Task task = new Task();
        task.setId(rs.getInt("id"));
        task.setTitle(rs.getString("title"));
        task.setDetail(rs.getString("detail"));
        task.setCompleted(rs.getBoolean("completed"));
        task.setData_creare(rs.getDate("data_creare"));
        task.setDeadline(rs.getDate("deadline"));

        tasks.add(task);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return tasks;
  }
}
