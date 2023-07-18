package edu.mathematics.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public interface MyController {
    void setData();

    default void init(String fxml, MyController myController, StackPane root) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(fxml));
            AnchorPane anchorPane = fxmlLoader.load();
            root.getChildren().add(anchorPane);

            myController = fxmlLoader.getController();
            myController.setData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}