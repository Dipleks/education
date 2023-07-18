package edu.mathematics.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SchoolMasterController implements Initializable {
    @FXML
    private StackPane root;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getInit();
    }

    @FXML
    private void getTasks() {
        root.getChildren().clear();
        getInit();
    }

    @FXML
    private void getExamples() {
        root.getChildren().clear();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/view/examples.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            root.getChildren().add(anchorPane);

            ExamplesController examplesController = fxmlLoader.getController();
            examplesController.setData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void getMultiplicationTable() {
        root.getChildren().clear();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/view/multiplicationTable.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            root.getChildren().add(anchorPane);

            MultiplicationTableController mtc = fxmlLoader.getController();
            mtc.setData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void getInit() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/view/tasks.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            root.getChildren().add(anchorPane);

            TasksController tasksController = fxmlLoader.getController();
            tasksController.setData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
