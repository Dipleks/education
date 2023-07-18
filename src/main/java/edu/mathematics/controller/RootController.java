package edu.mathematics.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {
    @FXML
    private StackPane rootPane;

    @FXML
    private void getMathematics() {
         rootPane.getChildren().clear();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/view/mathematics.fxml"));
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
            fxmlLoader.setLocation(getClass().getResource("/view/english.fxml"));
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
            fxmlLoader.setLocation(getClass().getResource("/view/mathematics.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            rootPane.getChildren().add(anchorPane);

//            SchoolMasterController schoolMasterController = fxmlLoader.getController();
//            schoolMasterController.setData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
