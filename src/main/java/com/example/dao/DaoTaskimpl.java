package com.example.dao;

import com.example.model.Task;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DaoTaskimpl {
  private Connection connect() {
    try {
      String url = "jdbc:sqlite:tasks.db";
      Connection conn = DriverManager.getConnection(url);
      System.out.println("✅ Conectat la baza de date: " + url);
      return conn;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  public void createTable() {
    String sql =
        "CREATE TABLE IF NOT EXISTS tasks ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "title TEXT NOT NULL,"
            + "detail TEXT,"
            + "completed BOOLEAN DEFAULT 0,"
            + "deadline DATE)";
    try (Connection conn = connect();
        Statement stmt = conn.createStatement()) {
      stmt.execute(sql);
      System.out.println("✅ Tabela 'tasks' este pregătită.");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public List<Task> getAllTask() {
    List<Task> list = new ArrayList<>();
    String sql = "SELECT * FROM tasks";
    try (Connection conn = connect();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery()) {

      while (rs.next()) {
        LocalDate deadline = null;
        Date dbDate = rs.getDate("deadline");
        if (dbDate != null) {
          deadline = dbDate.toLocalDate();
        }

        Task t =
            new Task(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("detail"),
                rs.getBoolean("completed"),
                deadline);
        list.add(t);
      }

      System.out.println("📦 getAllTask() a returnat: " + list.size() + " elemente");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return list;
  }

  public void addTask(Task task) {
    String sql = "INSERT INTO tasks (title, detail, completed, deadline) VALUES (?, ?, ?, ?)";
    try (Connection conn = connect();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setString(1, task.getTitle());
      stmt.setString(2, task.getDetail());
      stmt.setBoolean(3, task.isCompleted());
      if (task.getDeadline() != null) {
        stmt.setDate(4, Date.valueOf(task.getDeadline()));
      } else {
        stmt.setNull(4, Types.DATE);
      }
      stmt.executeUpdate();
      System.out.println("✅ Task adăugat cu succes!");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void deleteTask(int id) {
    String sqlDelete = "DELETE FROM tasks WHERE id = ?";
    String sqlReindex =
        """
        UPDATE tasks
        SET id = (
            SELECT COUNT(*) + 1
            FROM tasks AS t2
            WHERE t2.id < tasks.id
        );
        """;
    String sqlReset = "DELETE FROM sqlite_sequence WHERE name='tasks';"; // resetează AUTO INCREMENT

    try (Connection conn = connect();
        PreparedStatement stmt = conn.prepareStatement(sqlDelete)) {

      // 1️⃣ Șterge taskul
      stmt.setInt(1, id);
      stmt.executeUpdate();
      System.out.println("✅ Task șters cu succes!");

      // 2️⃣ Reindexează ID-urile în ordine
      try (Statement st = conn.createStatement()) {
        st.executeUpdate(sqlReindex);
        st.executeUpdate(sqlReset);
      }

      System.out.println("🔄 ID-urile au fost reindexate corect (SQLite)!");

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void updateTask(Task task) {
    String sql = "UPDATE tasks SET title = ?, detail = ?, completed = ?, deadline = ? WHERE id = ?";
    try (Connection conn = connect();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setString(1, task.getTitle());
      stmt.setString(2, task.getDetail());
      stmt.setBoolean(3, task.isCompleted());
      if (task.getDeadline() != null) {
        stmt.setDate(4, Date.valueOf(task.getDeadline()));
      } else if (task.getDeadline().isBefore(LocalDate.now())) {
        stmt.setNull(4, Types.DATE);
      } else {
        stmt.setNull(4, Types.DATE);
      }
      stmt.setInt(5, task.getId());
      stmt.executeUpdate();
      System.out.println("✅ Task actualizat cu succes!");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
