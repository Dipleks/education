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
        getInit("/view/tasks.fxml", new TasksController());
    }

    @FXML
    private void getTasks() {
        root.getChildren().clear();
        getInit("/view/tasks.fxml",  new TasksController());
    }

    @FXML
    private void getExamples() {
        root.getChildren().clear();
        getInit("/view/examples.fxml", new ExamplesController());
    }

    @FXML
    private void getMultiplicationTable() {
        root.getChildren().clear();
        getInit("/view/multiplicationTable.fxml", new MultiplicationTableController());
    }

    @FXML
    private void addTask() {
        root.getChildren().clear();
        getInit("/view/addNewTask.fxml", new AddNewTaskController());
    }

    private void getInit(String fxml, MyController controller) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(fxml));
            AnchorPane anchorPane = fxmlLoader.load();
            root.getChildren().add(anchorPane);

            controller = fxmlLoader.getController();
            controller.setData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
