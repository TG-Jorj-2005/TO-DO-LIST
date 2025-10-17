package java;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage stage) {
    Label label = new Label("Salut, Jorj! 🎉 JavaFX merge!");
    Scene scene = new Scene(label, 400, 200);
    stage.setScene(scene);
    stage.setTitle("Test JavaFX");
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
