package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

  @Override
  public void start(Stage stage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/MainView.fxml"));
    Scene scene = new Scene(loader.load());

    stage.setTitle("To-Do List");
    stage.setScene(scene);
    stage.setResizable(true);
    stage.show();
  }

  public static void main(String[] args) {
    launch(); // pornește aplicația JavaFX
  }
}
