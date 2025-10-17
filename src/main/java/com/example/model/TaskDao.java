package com.example.model;

import java.util.List;

// **Interfata cu metode abstracte
public interface TaskDao {

  void addTask(Task task);

  void deleteTask(int id);

  void updateTask(Task task);

  Task getTaskById(int id);

  List<Task> getAllTask();
}
