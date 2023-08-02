package edu.controller.mathematics;

import edu.controller.MyController;
import edu.controller.PathFXML;
import edu.model.mathematicks.Tasks;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.StackPane;
import java.net.URL;
import java.util.ResourceBundle;

public class MathematicsController implements Initializable, MyController, PathFXML {
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        init(TASKS, new TasksController(), root);
        Tasks.copyTasksInBufferTable();
    }

    @FXML
    private void getTasks() {
        root.getChildren().clear();
        init(TASKS,  new TasksController(), root);
        isSelected(tasks, examples, multiTable, addButtonTask);
    }

    @FXML
    private void getExamples() {
        root.getChildren().clear();
        init(EXAMPLES, new ExamplesController(), root);
        isSelected(examples, tasks, multiTable, addButtonTask);
    }

    @FXML
    private void getMultiplicationTable() {
        root.getChildren().clear();
        init(MULTIPLICATION_TABLE, new MultiplicationTableController(), root);
        isSelected(multiTable, tasks, examples, addButtonTask);
    }

    @FXML
    private void addTask() {
        root.getChildren().clear();
        init(ADD_NEW_TASK, new AddNewTaskController(), root);
        isSelected(addButtonTask, tasks, examples, multiTable);
    }

    @Override
    public void setData() {

    }
}
