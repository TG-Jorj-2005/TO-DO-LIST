package com.example.controller;

import com.example.dao.DaoTaskimpl;
import com.example.model.Task;
import com.example.model.TaskDao;
import java.util.List;

public class TaskController {
  private TaskDao taskdao;

  public TaskController() {

    taskdao = new DaoTaskimpl();
  }

  public void addTask(Task task) {
    try {
      taskdao.addTask(task);
    } catch (Exception e) {
      System.out.println("Eroare: " + e.getMessage());
    }
  }

  public void updateTask(Task task) {
    try {
      taskdao.updateTask(task);
    } catch (Exception e) {
      System.out.println("Eroare: " + e.getMessage());
    }
  }

  public void deleteTask(int id) {
    try {
      taskdao.deleteTask(id);
    } catch (Exception e) {
      System.err.println("Eroare : " + e.getMessage());
    }
  }

  public Task getTaskById(int id) {
    return taskdao.getTaskById(id);
  }

  public List<Task> getAllTask() {
    return taskdao.getAllTask();
  }
}
