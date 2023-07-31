package edu.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable, PathFXML {
    @FXML
    private StackPane rootPane;

    @FXML
    private void getMathematics() {
         rootPane.getChildren().clear();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(MATHEMATICS));
            AnchorPane anchorPane = fxmlLoader.load();
            rootPane.getChildren().add(anchorPane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void getEnglish() {
         rootPane.getChildren().clear();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(ENGLISH));
            AnchorPane anchorPane = fxmlLoader.load();
            rootPane.getChildren().add(anchorPane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void getSettingsDB() {
        rootPane.getChildren().clear();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(SETTINGS_DB));
            AnchorPane anchorPane = fxmlLoader.load();
            rootPane.getChildren().add(anchorPane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(MATHEMATICS));
            AnchorPane anchorPane = fxmlLoader.load();
            rootPane.getChildren().add(anchorPane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
