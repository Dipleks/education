package edu.controller.mathematics;

import edu.controller.MyController;
import edu.model.mathematicks.TaskHandler;
import edu.model.mathematicks.Tasks;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import java.net.URL;
import java.util.ResourceBundle;

public class TasksController implements MyController, PathFXML, Initializable{

    @FXML
    private StackPane condition;
    @FXML
    private Label conditionTask;
    @FXML
    private TextField answerTask;
    @FXML
    private Label status;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            conditionTask.setText(Tasks.showCondition());
        } catch (Exception ex) {
            condition.getChildren().clear();
            init(ERROR_GET_TASK, new ErrorGetTask(), condition);
        }
    }

    @FXML
    private void checkAnswer() {
        check();
    }

    @FXML
    private void pressEnter(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            check();
        }
    }

    private void check() {
        try {
            if (answerTask.getText().equalsIgnoreCase(Tasks.checkAnswer())) {
                TaskHandler.updateStatus(Tasks.getID());
                Tasks.deleteTasksFromBuffer();
                answerTask.clear();

                conditionTask.setText(Tasks.showCondition());

                status.setStyle("-fx-text-fill: green;");
                status.setText("Верно! Молодец!!!");
            } else {
                answerTask.clear();
                status.setStyle("-fx-text-fill: red;");
                status.setText("Не верно! Попробуй еще раз!");

                conditionTask.setText(Tasks.tryingDecide());
            }
        } catch (Exception ex) {
            condition.getChildren().clear();
            init(ERROR_END_TASK, new ErrorGetTask(), condition);
        }
    }
    public void setData() {

    }
}
