package edu.mathematics.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MathematicsController implements Initializable, MyController {
    @FXML
    private StackPane root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        init("/view/tasks.fxml", new TasksController(), root);
    }

    @FXML
    private void getTasks() {
        root.getChildren().clear();
        init("/view/tasks.fxml",  new TasksController(), root);
    }

    @FXML
    private void getExamples() {
        root.getChildren().clear();
        init("/view/examples.fxml", new ExamplesController(), root);
    }

    @FXML
    private void getMultiplicationTable() {
        root.getChildren().clear();
        init("/view/multiplicationTable.fxml", new MultiplicationTableController(), root);
    }

    @FXML
    private void addTask() {
        root.getChildren().clear();
        init("/view/addNewTask.fxml", new AddNewTaskController(), root);
    }

    @Override
    public void setData() {

    }
}
