package spaceinvader.spaceinvader;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.layout.GridPane;

import java.net.URL;

public class SpaceController {

    @FXML
    private Label score;

    @FXML
    private Label life;

    @FXML
    private GridPane gameGrid;


    @FXML
    private void initialize() {
        score.setText("Score : 0");
        life.setText("Vie : 3");

        for (int  i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                Label label = new Label();
                label.setMinSize(50,10);
                label.setBackground(createBackground("back"));;
                gameGrid.add(label, j, i);
            }
        }
    }

    private Background createBackground(String name) {
        URL urlImage = getClass().getResource("/spaceinvader/spaceinvader/img/" + name + ".png");
        BackgroundImage backgroundImage = new BackgroundImage(
                new Image(urlImage.toExternalForm(), 50, 50, false, true),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        return new Background(backgroundImage);
    }

}