/**
 * Colton Kohler
 * M7: Programming Assignment
 * 4/23/2025
 * This program demonstrates how to use JavaFX with an external CSS file to style and
 * arrange multiple circles with different visual properties using classes and IDs.
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // First circle with tall border box
        Circle c1 = new Circle(40);
        c1.getStyleClass().add("plaincircle");

        StackPane borderedCircle = new StackPane(c1);
        borderedCircle.getStyleClass().add("border");
        borderedCircle.setPrefSize(90, 300); //
        borderedCircle.setMaxSize(90, 300);
        borderedCircle.setMinSize(90, 300);

        // Second circle - plain
        Circle c2 = new Circle(40);
        c2.getStyleClass().add("plaincircle");

        // Third circle - red
        Circle c3 = new Circle(40);
        c3.setId("redcircle");

        // Fourth circle - green
        Circle c4 = new Circle(40);
        c4.setId("greencircle");

        // Layout all items side by side
        HBox root = new HBox(20, borderedCircle, c2, c3, c4);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(root);
        scene.getStylesheets().add("file:mystyle.css");

        primaryStage.setTitle("Exercise31_01");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
