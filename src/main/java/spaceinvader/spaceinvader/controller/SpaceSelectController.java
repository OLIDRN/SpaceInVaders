package spaceinvader.spaceinvader.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import spaceinvader.spaceinvader.model.SpriteStore;

public class SpaceSelectController {

    @FXML
    private ListView<String> listselect;

    private SpriteStore store;

    @FXML
    private ImageView img1;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img3;

    void initialize() {
        listselect.setItems(FXCollections.observableArrayList("asterix", "base", "starwars"));
        listselect.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            store = new SpriteStore(newValue);
            img1.setImage(store.createSprite("back"));
            img2.setImage(store.createSprite("back"));
            img3.setImage(store.createSprite("back"));
        });

    }
}
