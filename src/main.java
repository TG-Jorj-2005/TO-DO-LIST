import javafx.application.Application;
import javafx.collections.FXCollections; // ← ADAUGĂ
import javafx.collections.ObservableList; // ← ADAUGĂ
import javafx.scene.Scene;
import javafx.scene.control.TableView; // ← ADAUGĂ
// ← ADAUGĂ
// ← ADAUGĂ ()
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Task;

public class main extends Application {

  private ObservableList<Task> tasks;

  @Override
  public void start(Stage primaryStage) {
    // Aici vei construi UI-ul
    tasks = FXCollections.observableArrayList();
    TableView<Task> tableview = new TableView<>(tasks);

    BorderPane root = new BorderPane();

    Scene scene = new Scene(root, 900, 600);

    primaryStage.setTitle("ToDo List App");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
