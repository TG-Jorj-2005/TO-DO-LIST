package com.example.controller;

import com.example.dao.DaoTaskimpl;
import com.example.model.Task;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class MainViewController {
  @FXML private Button add;
  @FXML private Button delete;
  @FXML private Button inbox;
  @FXML private Button calendar;
  private final DaoTaskimpl daoTaskimpl = new DaoTaskimpl();
  @FXML TableView<Task> task;

  @FXML
  public void initializare() {
    handleAddButton();
    loadTask();
  }

  @FXML
  private void handleAddButton() {
    add.setOnAction(
        event -> {
          // Codul pentru a deschide fereastra de adăugare a unei sarcini noi
        });
    delete.setOnAction(
        event -> {
          // Codul pentru a șterge sarcina selectată din tabel
        });
    inbox.setOnAction(
        event -> {
          // Codul pentru a afișa sarcinile din inbox
          // Poate implica filtrarea sarcinilor și actualizarea TableView
        });
    calendar.setOnAction(
        event -> {
          // Codul pentru a deschide vizualizarea calendarului
          // Poate implica deschiderea unei noi ferestre sau schimbarea scenei
        });
  }

  @FXML
  private void loadTask() {
    ObservableList<Task> tasks = task.getItems();
    tasks.clear();
    tasks.addAll(daoTaskimpl.getAllTask());
    task.setItems(tasks);
  }
}
