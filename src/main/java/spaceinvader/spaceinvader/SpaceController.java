package spaceinvader.spaceinvader;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SpaceController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

}