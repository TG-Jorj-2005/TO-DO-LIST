package controller;

import java.sql.Connection;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Task;
import service.TaskServices;
import util.DatabaseConnection;

public class TaskController {
  @FXML private TextField titleField;
  @FXML private TextArea detailArea;
  @FXML private DatePicker deadlinePicker;
  @FXML private Label messageLabel;

  private TaskServices taskService;

  public void initialize() {
    try {
      Connection conn = DatabaseConnection.getConnection();
      taskService = new TaskServices(conn);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @FXML
  private void handleAddTask() {
    try {
      Task task = new Task();
      task.setTitle(titleField.getText());
      task.setDetail(detailArea.getText());
      task.setData_creare(new java.sql.Date(System.currentTimeMillis()));
      task.setDeadline(java.sql.Date.valueOf(deadlinePicker.getValue()));
      task.setCompleted(false);

      taskService.addTask(task);
      messageLabel.setText("Task adăugat cu succes!");
    } catch (Exception e) {
      messageLabel.setText("Eroare: " + e.getMessage());
    }
  }
}
