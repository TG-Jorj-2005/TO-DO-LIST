package service;

import Dao.TaskDao;
import Dao.impl.TaskDaoimpl;
import java.sql.Connection;
import java.util.List;
import model.Task;

public class TaskServices {
  private final TaskDao taskdao;

  public TaskServices(Connection connection) {
    taskdao = new TaskDaoimpl(connection);
  }

  public void addTask(Task task) {
    try {
      if (task.getTitle() == null || task.getTitle().isEmpty()) {
        throw new Exception("Nume inexistent");
      }

      if (task.getDetail() == null || task.getDetail().isEmpty()) {
        throw new Exception("Fără descriere");
      }

      if (task.getData_creare() == null) {
        throw new Exception("Data creare lipsă");
      }

      if (task.getDeadline() == null) {
        throw new Exception("Deadline lipsă");
      }

    } catch (Exception e) {
      System.out.println("Eroare la task ID " + task.getId() + ": " + e.getMessage());
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
        throw new Exception("Fără descriere");
      }

      if (task.getData_creare() == null) {
        throw new Exception("Data creare lipsă");
      }

      if (task.getDeadline() == null) {
        throw new Exception("Deadline lipsă");
      }

    } catch (Exception e) {
      System.out.println("Eroare la task ID " + task.getId() + ": " + e.getMessage());
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

  public List<Task> getAllTasks() {
    List<Task> tasks = taskdao.getAllTasks(); // iei lista o singură dată

    for (Task task : tasks) {
      try {
        if (task.getTitle() == null || task.getTitle().isEmpty()) {
          throw new Exception("Nume inexistent");
        }

        if (task.getDetail() == null || task.getDetail().isEmpty()) {
          throw new Exception("Fără descriere");
        }

        if (task.getData_creare() == null) {
          throw new Exception("Data creare lipsă");
        }

        if (task.getDeadline() == null) {
          throw new Exception("Deadline lipsă");
        }

      } catch (Exception e) {
        System.out.println("Eroare la task ID " + task.getId() + ": " + e.getMessage());
      }
    }

    return tasks; // returnezi lista verificată
  }
}
