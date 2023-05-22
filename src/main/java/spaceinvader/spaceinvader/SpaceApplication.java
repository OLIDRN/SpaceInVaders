package spaceinvader.spaceinvader;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SpaceApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SpaceApplication.class.getResource("view/space-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1038, 800);
        spaceinvader.spaceinvader.controller.SpaceController control = fxmlLoader.getController();
        control.setStage(stage);
        stage.setTitle("SpaceInVader by viervier");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

