package Dao;

import java.sql.*;
import java.util.*;
import model.Task;

public interface TaskDao {

  void addTask(Task task);

  void deleteTask(int taskId);

  Task getTaslById(int taksId);

  List<Task> getAllTasks();
}
