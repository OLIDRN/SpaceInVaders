package spaceinvader.spaceinvader;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import spaceinvader.spaceinvader.controller.SpaceController;
import spaceinvader.spaceinvader.model.SpaceInvadersGame;
import spaceinvader.spaceinvader.model.*;

import java.io.IOException;

public class SpaceApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SpaceApplication.class.getResource("view/space-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1038, 700);
        //SpaceController control = fxmlLoader.getController();
        SpriteStore store = new SpriteStore("base");
        //SpaceInvadersGame spaceinvader = new SpaceInvadersGame(10,20,store);
        //control.setSpaceInvaders(spaceinvader);
        //spaceinvader.setController(control);
        //control.setStage(stage);
        //spaceinvader.prepare();
        //spaceinvader.start();
        stage.setTitle("SpaceInVader by viervier");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

