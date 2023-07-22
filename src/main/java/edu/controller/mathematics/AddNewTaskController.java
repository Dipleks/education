package edu.controller.mathematics;

import edu.controller.MyController;
import edu.model.TaskHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddNewTaskController implements MyController {

    @FXML
    private TextArea conditionTask;
    @FXML
    private TextField answerTask;

    @FXML
    private void addNewTask() {
        TaskHandler.addNewTask(conditionTask.getText(), answerTask.getText());
    }

    public void setData(){

    }
}
