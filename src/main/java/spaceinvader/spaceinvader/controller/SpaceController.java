package spaceinvader.spaceinvader.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import spaceinvader.spaceinvader.model.AbstractMovable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;

import java.net.URL;

public class SpaceController implements spaceinvader.spaceinvader.model.Interface {

    @FXML
    private Label score;

    @FXML
    private Label life;

    @FXML
    private GridPane gameGrid;

    private Stage stage;

    private Label[][] labels = new Label[10][20];


    private spaceinvader.spaceinvader.model.SpaceInvadersGame spaceInvadersGame;

    public void setSpaceInvaders(spaceinvader.spaceinvader.model.SpaceInvadersGame spaceInvader) {
        this.spaceInvadersGame = spaceInvader;
    }

    @Override
    public void setGameGrid(spaceinvader.spaceinvader.model.GameGrid gameGrid) {
        for (int  i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                extracted(gameGrid, i, j);
            }
        }

    }

    private void extracted(spaceinvader.spaceinvader.model.GameGrid gameGrid, int i, int j) {
        gameGrid.get(i, j).getMovableProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                javafx.scene.Node graphic = createGraphicFor(newValue);
                labels[i][j].setGraphic(graphic);
            } else {
                labels[i][j].setGraphic(null);
            }
        });
    }

    private Node createGraphicFor(AbstractMovable movable) {
        HBox box = new HBox();
        box.setPrefHeight(50);
        box.setPrefWidth(50);
        box.setAlignment(Pos.CENTER);
        ImageView view = new ImageView(movable.getSprite());
        box.getChildren().add(view);

        return box;
    }


    @Override
    public void addMovable(spaceinvader.spaceinvader.model.AbstractMovable movable) {
        
    }

    @Override
    public void removeMovable(spaceinvader.spaceinvader.model.AbstractMovable movable) {

    }

    @Override
    public void endGame(String message) {

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void initialize() {
        Stage stage = new Stage();
        score.setText("Score : 0");
        life.setText("Vie : 3");

        for (int  i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                Label label = new Label();
                labels[i][j] = label;
                label.setMinSize(50,50);
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