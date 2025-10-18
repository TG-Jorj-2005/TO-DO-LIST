package com.example.controller;

import com.example.dao.DaoTaskimpl;
import com.example.model.Task;
import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddTaskController {
  @FXML private TextField name;
  @FXML private TextArea descriere;
  @FXML private DatePicker deadline;
  @FXML private CheckBox complet;
  @FXML private Button save;
  @FXML private Button cancel;

  private final DaoTaskimpl dao = new DaoTaskimpl();

  @FXML
  public void initialize() {
    save.setOnAction(e -> saveTask());
    cancel.setOnAction(e -> ((Stage) cancel.getScene().getWindow()).close());
  }

  private void saveTask() {
    String title = name.getText();
    String detail = descriere.getText();
    LocalDate date = deadline.getValue();
    boolean completed = complet.isSelected();

    if (title == null || title.trim().isEmpty()) {
      showAlert("Titlul este obligatoriu!");
      return;
    }

    Task task = new Task(title, detail, completed, date);
    dao.addTask(task);

    // Închide fereastra după salvare
    ((Stage) save.getScene().getWindow()).close();
  }

  private void showAlert(String message) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Atenție");
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
  }
}
