package edu.controller.mathematics;

import edu.controller.MyController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.StackPane;
import java.net.URL;
import java.util.ResourceBundle;

public class MathematicsController implements Initializable, MyController {
    @FXML
    private ToggleButton tasks;
    @FXML
    private ToggleButton examples;
    @FXML
    private ToggleButton multiTable;
    @FXML
    private ToggleButton addButtonTask;
    @FXML
    private StackPane root;

    private final String tasksFXML = "/view/mathematics/tasks.fxml";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        init(tasksFXML, new TasksController(), root);
    }

    @FXML
    private void getTasks() {
        root.getChildren().clear();
        init(tasksFXML,  new TasksController(), root);
        isSelected(tasks, examples, multiTable, addButtonTask);
    }

    @FXML
    private void getExamples() {
        root.getChildren().clear();
        init("/view/mathematics/examples.fxml", new ExamplesController(), root);
        isSelected(examples, tasks, multiTable, addButtonTask);
    }

    @FXML
    private void getMultiplicationTable() {
        root.getChildren().clear();
        init("/view/mathematics/multiplicationTable.fxml", new MultiplicationTableController(), root);
        isSelected(multiTable, tasks, examples, addButtonTask);
    }

    @FXML
    private void addTask() {
        root.getChildren().clear();
        init("/view/mathematics/addNewTask.fxml", new AddNewTaskController(), root);
        isSelected(addButtonTask, tasks, examples, multiTable);
    }

    @Override
    public void setData() {

    }
}