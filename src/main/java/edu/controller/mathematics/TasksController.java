package edu.controller.mathematics;

import edu.controller.MyController;
import edu.model.TaskHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TasksController implements MyController, Initializable{

    @FXML
    private StackPane condition;
    @FXML
    private Label conditionTask;
    @FXML
    private TextField answerTask;
    @FXML
    private Label status;

    private int TRY_ANSWER = 1;
    private int NET_CONDITION = 1;

    @FXML
    private void checkAnswer() {
        if (answerTask.getText().equalsIgnoreCase(TaskHandler.getAnswer())) {
            TaskHandler.isStatus();
            answerTask.clear();

            getConditionTask();

            status.setStyle("-fx-text-fill: green;");
            status.setText("Верно! Молодец!!!");
        } else {
            answerTask.clear();
            status.setStyle("-fx-text-fill: red;");
            status.setText("Не верно! Попробуй еще раз!");
            getNextConditionTask();
        }
    }

    public void setData() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getConditionTask();
    }

    private void getConditionTask() {
        try {
            conditionTask.setText(TaskHandler.getCondition());
        } catch (Exception ex) {
            condition.getChildren().clear();
            init("/view/mathematics/errorGetTask.fxml", new ErrorGetTask(), condition);
        }
    }

    private void getNextConditionTask() {
        if (TRY_ANSWER == 3) {
            answerTask.clear();
            status.setStyle("-fx-text-fill: orange;");
            status.setText("Давай пропустим эту задачу и вернёмся к ней в другой раз!");
            try {
                NET_CONDITION++;
                TRY_ANSWER = 1;
                if(NET_CONDITION == 4) {
                    NET_CONDITION = 1;
                    getConditionTask();
                } else {
                    conditionTask.setText(TaskHandler.getCondition(NET_CONDITION));
                }
            } catch (Exception ex) {
                condition.getChildren().clear();
                init("/view/mathematics/errorGetTask.fxml", new ErrorGetTask(), condition);
            }
        } else {
            TRY_ANSWER++;
        }

    }
}
