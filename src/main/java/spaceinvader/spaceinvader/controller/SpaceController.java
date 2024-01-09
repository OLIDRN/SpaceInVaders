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
import spaceinvader.spaceinvader.model.*;
import javafx.beans.property.IntegerProperty;

import java.net.URL;

public class SpaceController implements spaceinvader.spaceinvader.model.Interface {

    @FXML
    private Label score;

    @FXML
    private Label life;

    @FXML
    private GridPane gameGrid;

    @FXML
    private Label labelle;

    private Stage stage;

    private Label[][] labels = new Label[10][20];

    private SpaceInvadersGame spaceInvadersGame;

    private SpriteStore store;

    public void setSpaceInvaders(SpaceInvadersGame spaceInvader) {
        this.spaceInvadersGame = spaceInvader;
    }

    @Override
    public void setGameGrid(GameGrid gameGrid) {
        labelle.setVisible(false);
        for (int  i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                labels[i][j] = new Label();
                Label label = labels[i][j];
                label.setMinSize(50, 50);
                label.setBackground(createBackground("back"));
                this.gameGrid.add(label, j, i);
                extracted(gameGrid, i, j);
            }
        }

    }

    private void extracted(GameGrid gameGrid, int i, int j) {
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
    public void addMovable(AbstractMovable movable) {
        if (movable != null) {
            javafx.scene.Node graphic = createGraphicFor(movable);
            labels[movable.getRow()][movable.getColumn()].setGraphic(graphic);
        }
    }

    @Override
    public void removeMovable(AbstractMovable movable) {
        if (movable != null) {
            labels[movable.getRow()][movable.getColumn()].setGraphic(null);
        }
    }

    @Override
    public void endGame(String message) {
        labelle.setVisible(true);
        labelle.setText(message);
    }

    @Override
    public void setScore(IntegerProperty score) {
        this.score.textProperty().bind(score.asString());
    }

    @Override
    public void setLife(IntegerProperty life) {
        this.life.textProperty().bind(life.asString());
    }

    public void setStage(Stage stage) {
        this.stage = stage;
        stage.addEventFilter(javafx.scene.input.KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()){
                case LEFT -> {
                    spaceInvadersGame.moveLeft();
                }
                case RIGHT -> {
                    spaceInvadersGame.moveRight();
                }
            }
        });
        stage.addEventFilter(javafx.scene.input.KeyEvent.KEY_TYPED, event -> {
            switch (event.getCharacter()){
                case " " -> {
                    spaceInvadersGame.fireShot();
                }
            }
        });
    }

    public void setStore(SpriteStore store) {
        this.store = store;
    }


    private Background createBackground(String name) {
        BackgroundImage backgroundImage = new BackgroundImage(
                    store.createSprite(name),
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT);
        return new Background(backgroundImage);
    }
}