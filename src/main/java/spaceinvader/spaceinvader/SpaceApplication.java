package spaceinvader.spaceinvader;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import spaceinvader.spaceinvader.controller.SpaceController;
import spaceinvader.spaceinvader.controller.SpaceSelectController;
import spaceinvader.spaceinvader.model.SpaceInvadersGame;
import spaceinvader.spaceinvader.model.*;

import java.io.IOException;

public class SpaceApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SpaceApplication.class.getResource("view/select-theme.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1038, 700);
        SpaceSelectController selectController = fxmlLoader.getController();
        selectController.setStage(stage);
        stage.setTitle("SpaceInVader by viervier");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

