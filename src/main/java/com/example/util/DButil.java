package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {

  // URL-ul bazei de date SQLite (un fișier local)
  private static final String URL = "jdbc:sqlite:tasks.db";

  // Conexiune unică (singleton)
  private static Connection connection = null;

  // Metoda care returnează conexiunea activă
  public static Connection getConnection() throws SQLException {
    if (connection == null || connection.isClosed()) {
      connection = DriverManager.getConnection(URL);
      System.out.println("✅ Conectat la baza de date: " + URL);
    }
    return connection;
  }

  // Metodă pentru închiderea conexiunii în siguranță
  public static void closeConnection() {
    try {
      if (connection != null && !connection.isClosed()) {
        connection.close();
        System.out.println("🔒 Conexiune închisă.");
      }
    } catch (SQLException e) {
      System.err.println("Eroare la închiderea conexiunii: " + e.getMessage());
    }
  }
}
