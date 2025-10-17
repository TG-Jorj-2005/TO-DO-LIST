package service;

import Dao.TaskDao;
import java.time.LocalDateTime;
import model.Task;

public class TaskServices {
  private TaskDao taskdao;

  public TaskServices(TaskDao task) {
    taskdao = task;
  }

  public void addTask(Task task) {
    try {
      if (task.getTitle() == null || task.getTitle().isEmpty()) {
        throw new Exception("Nume inexistent");
      }

      if (task.getDetail() == null || task.getDetail().isEmpty()) {
        throw new Exception("Fara descriere");
      }

      if (task.getData_creare() == null) {
        task.setData_creare(LocalDateTime.now());
      }
      if (task.getDeadline() == null) {
        task.setDeadline(LocalDateTime.now());
      }
    } catch (Exception e) {
      System.out.println("Erori : " + e.getMessage());
    }
    taskdao.addTask(task);
  }

  public void deleteTask(int id) {
    taskdao.deleteTask(id);
  }

  public void updateTask(Task task) {
    try {
      if (task.getTitle() == null || task.getTitle().isEmpty()) {
        throw new Exception("Nume inexistent");
      }

      if (task.getDetail() == null || task.getDetail().isEmpty()) {
        throw new Exception("Fara descriere");
      }

      if (task.getData_creare() == null) {
        task.setData_creare(LocalDateTime.now());
      }
      if (task.getDeadline() == null) {
        task.setDeadline(LocalDateTime.now());
      }
    } catch (Exception e) {
      System.out.println("Erori : " + e.getMessage());
    }
    taskdao.updateTask(task);
  }

  public Task getTaskById(int id) {
    try {
      if (id < 0 && id > taskdao.getAllTasks().size()) throw new Exception("id necorespunzator");
    } catch (Exception e) {
      System.out.println("Erori: " + e.getMessage());
    }
    return taskdao.getTaskById(id);
  }
}
