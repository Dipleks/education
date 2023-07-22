package edu.controller.mathematics;

import edu.controller.MyController;
import edu.model.TaskHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class TasksController implements MyController, Initializable{

    @FXML
    private Label conditionTask;
    @FXML
    private TextField answerTask;
    @FXML
    private Label status;

    @FXML
    private void checkAnswer() {
        if (answerTask.getText().equalsIgnoreCase(TaskHandler.getAnswer())) {
            TaskHandler.isStatus();
            answerTask.clear();
            conditionTask.setText(TaskHandler.getCondition());
            status.setStyle("-fx-text-fill: green;");
            status.setText("Верно! Молодец!!!");
        } else {
            status.setStyle("-fx-text-fill: red;");
            status.setText("Не верно! Попробуй еще раз!");
        }
    }

    public void setData() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        conditionTask.setText(TaskHandler.getCondition());
    }
}
