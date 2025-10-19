package com.example.controller;

import com.example.dao.DaoTaskimpl;
import com.example.model.Task;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainViewController {

  @FXML private Button add;
  @FXML private Button delete;
  @FXML private Button inbox;
  @FXML private Button calendar;

  @FXML private TableView<Task> task;
  @FXML private TableColumn<Task, Integer> idColumn;
  @FXML private TableColumn<Task, String> titleColumn;
  @FXML private TableColumn<Task, String> detailColumn;
  @FXML private TableColumn<Task, Boolean> completedColumn;
  @FXML private TableColumn<Task, String> deadlineColumn;

  private final DaoTaskimpl daoTaskimpl = new DaoTaskimpl();

  @FXML
  public void initialize() {
    setupColumns();
    handleAddButton();
    loadTask();
    updateTaskisCompleted();
  }

  private void setupColumns() {
    idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
    titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
    detailColumn.setCellValueFactory(new PropertyValueFactory<>("detail"));
    completedColumn.setCellValueFactory(new PropertyValueFactory<>("completed"));

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd MMM yyyy");
    deadlineColumn.setCellValueFactory(
        cellData -> {
          LocalDate date = cellData.getValue().getDeadline();
          String text = (date != null) ? fmt.format(date) : "";
          return new ReadOnlyStringWrapper(text);
        });
  }

  @FXML
  private void handleAddButton() {
    add.setOnAction(e -> openAddTask());
    delete.setOnAction(e -> handleDeleteButton());
  }

  @FXML
  private void loadTask() {
    ObservableList<Task> tasks = task.getItems();
    tasks.clear();
    tasks.addAll(daoTaskimpl.getAllTask());
    task.setItems(tasks);
  }

  @FXML
  private void openAddTask() {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/AddTask.fxml"));
      Parent root = loader.load();

      Stage stage = new Stage();
      stage.setTitle("Add Task");
      stage.setScene(new Scene(root));
      stage.initModality(Modality.APPLICATION_MODAL);
      stage.showAndWait();

      loadTask();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @FXML
  private void handleDeleteButton() {
    Task selectedTask = task.getSelectionModel().getSelectedItem();
    if (selectedTask != null) {
      daoTaskimpl.deleteTask(selectedTask.getId());
      loadTask();
    }
  }

  @FXML
  private void updateTaskisCompleted() {

    task.setRowFactory(
        tv -> {
          TableRow<Task> row = new TableRow<>();
          row.setOnMouseClicked(
              event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                  Task rowData = row.getItem();
                  rowData.setCompleted(!rowData.isCompleted());
                  daoTaskimpl.updateTask(rowData);
                  loadTask();
                }
              });
          return row;
        });
  }
}
