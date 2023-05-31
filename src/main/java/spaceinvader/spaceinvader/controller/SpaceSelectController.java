package spaceinvader.spaceinvader.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import spaceinvader.spaceinvader.SpaceApplication;
import spaceinvader.spaceinvader.model.SpaceInvadersGame;
import spaceinvader.spaceinvader.model.SpriteStore;

import java.io.IOException;

public class SpaceSelectController {

    @FXML
    private ListView<String> themeList;

    private SpriteStore store;

    @FXML
    private ImageView sky;

    @FXML
    private ImageView land;

    @FXML
    private ImageView ship;

    @FXML
    private ImageView shot;

    @FXML
    private ImageView alienShip;

    @FXML
    private ImageView alienShot;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    void initialize() {
        themeList.setItems(FXCollections.observableArrayList("asterix","base","starwars"));

        themeList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            store = new SpriteStore(newValue);
            sky.setImage(store.createSprite("back"));
            land.setImage(store.createSprite("land"));
            ship.setImage(store.createSprite("ship"));
            shot.setImage(store.createSprite("shot"));
            alienShip.setImage(store.createSprite("alien"));
            alienShot.setImage(store.createSprite("alien-shot"));
        });

    }

    @FXML
    void selectTheme(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SpaceApplication.class.getResource("view/space-view.fxml"));
        Parent view = fxmlLoader.load();
        SpaceController control = fxmlLoader.getController();
        control.setStage(stage);
        SpaceInvadersGame spaceinvader = new SpaceInvadersGame(10,20,store);
        control.setSpaceInvaders(spaceinvader);
        spaceinvader.setController(control);
        spaceinvader.prepare();
        spaceinvader.start();
        Scene scene = new Scene(view);
        stage.setScene(scene);
    }
}
