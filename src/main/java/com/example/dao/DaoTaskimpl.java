package com.example.dao;

import com.example.model.Task;
import com.example.model.TaskDao;
import com.example.util.DButil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoTaskimpl implements TaskDao {
  // *Implementarea functiilor abstracte*//
  @Override
  public void addTask(Task task) {

    String sql =
        "INSERT INTO tasks(id,title,detail,completed,createDate,deadline) VALUES (?,?,?,?,?,?)";
    try (Connection conn = DButil.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setInt(1, task.getId());
      stmt.setString(2, task.getTitle());
      stmt.setString(3, task.getDetail());
      stmt.setBoolean(4, task.isCompleted());
      stmt.setDate(5, task.getcreateDate());
      stmt.setDate(6, task.getdeadline());
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void updateTask(Task task) {
    String sql =
        "UPDATE tasks SET title = ?, description = ?, completed = ? ,done = ? WHERE id = ?";
    try (Connection conn = DButil.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setString(1, task.getTitle());
      stmt.setString(2, task.getDetail());
      stmt.setBoolean(3, task.isCompleted());
      stmt.setInt(4, task.getId());
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Task getTaskById(int id) {
    Task task = null;
    String sql = "SELECT * FROM tasks WHERE id = ?";
    try (Connection conn = DButil.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setInt(1, id);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        task =
            new Task(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("detail"),
                rs.getBoolean("completed"),
                rs.getDate("createDate"),
                rs.getDate("deadline"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return task;
  }

  @Override
  public void deleteTask(int id) {
    String sql = "DELETE FROM tasks WHERE id = ?";
    try (Connection conn = DButil.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setInt(1, id);
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<Task> getAllTask() {
    List<Task> task = new ArrayList<>();
    String sql = "SELECT * FROM tasks ORDER BY created_at DESC;";
    try (Connection conn = DButil.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        Task t =
            new Task(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("detail"),
                rs.getBoolean("completed"),
                rs.getDate("createDate"),
                rs.getDate("deadline"));
        task.add(t);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return task;
  }
}
