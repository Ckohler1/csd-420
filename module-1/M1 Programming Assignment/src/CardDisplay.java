/**
 * Colton Kohler
 * M1: Programming Assignment
 * 3/23/2025
 * Displays four randomly selected playing cards with a refresh button.
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDisplay extends Application {

    private static final int NUM_CARDS = 4;
    private static final String CARD_PATH = "file:/C:/Users/colko/Directories/CSD/csd-420/module-1/Cards/";

    private final List<ImageView> imageViews = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        HBox cardBox = new HBox(10);
        cardBox.setAlignment(Pos.CENTER);

        for (int i = 0; i < NUM_CARDS; i++) {
            ImageView iv = new ImageView();
            iv.setFitWidth(100);
            iv.setFitHeight(150);
            imageViews.add(iv);
            cardBox.getChildren().add(iv);
        }
        displayRandomCards();

        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(_ -> displayRandomCards());

        VBox root = new VBox(20, cardBox, refreshButton);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 500, 300);
        primaryStage.setTitle("Card Display");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void displayRandomCards() {
        List<Integer> deck = new ArrayList<>();
        for (int i = 1; i <= 52; i++) {
            deck.add(i);
        }
        Collections.shuffle(deck);

        for (int i = 0; i < NUM_CARDS; i++) {
            String imagePath = CARD_PATH + deck.get(i) + ".png";
            Image img = new Image(imagePath);
            imageViews.get(i).setImage(img);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
