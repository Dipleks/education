package edu.controller;

import edu.model.MathTask;
import edu.view.settings.NewWindow;
import edu.view.AlertWindow;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MathController {

    @FXML
    private Label number;
    @FXML
    private Label answerUser;
    @FXML
    private TextField answer;
    @FXML
    private Button start;
    @FXML
    private Label condition;
    @FXML
    private ToggleButton home;
    @FXML
    private ToggleButton tasks;
    @FXML
    private ToggleButton examples;
    @FXML
    private Pane mathHome;
    @FXML
    private Pane mathTask;
    @FXML
    private Pane mathExamples;

    @FXML
    private void getHome() {
        home.setSelected(true);
        tasks.setSelected(false);
        examples.setSelected(false);

        mathHome.setVisible(true);
        mathTask.setVisible(false);
        mathExamples.setVisible(false);
    }

    @FXML
    private void getTasks() {
        tasks.setSelected(true);
        home.setSelected(false);
        examples.setSelected(false);

        mathTask.setVisible(true);
        mathHome.setVisible(false);
        mathExamples.setVisible(false);

        //start.setDisable(false);
    }

    @FXML
    private void getExamples() {
        examples.setSelected(true);
        home.setSelected(false);
        tasks.setSelected(false);

        mathExamples.setVisible(true);
        mathTask.setVisible(false);
        mathHome.setVisible(false);
    }

    public static final Stage NEW_TASK = new Stage();
    @FXML
    private void addTask() {
        NewWindow.WINDOW.create(
                "/fxml/math-add-task.fxml",
                NEW_TASK,
                "Добавить новую задачу",
                true);
    }

    @FXML
    public void check() {
        MathTask.getTask()
                .forEach(taskEntity -> {
                    if (answer.getText().equalsIgnoreCase(taskEntity.getAnswer())) {
                        MathTask.editStatus(
                                taskEntity.getNumber(),
                                taskEntity.getCondition(),
                                taskEntity.getAnswer(),
                                true
                        );
                        MathTask.getTask()
                                .forEach(nextTask -> {
                                    condition.setText(nextTask.getCondition());
                                    number.setText(String.valueOf(nextTask.getNumber()));
                                });
                        answerUser.setText("Верно! Молодец!");
                        answerUser.setTextFill(Color.GREEN);
                    } else {
                        answerUser.setText("Не Верно! Попробуй еще раз!");
                        answerUser.setTextFill(Color.RED);
                    }
                });
        answer.clear();
    }

    @FXML
    private void startTask() {
        try {
            MathTask.getTask()
                    .forEach(taskEntity -> {
                        condition.setText(taskEntity.getCondition());
                        number.setText(String.valueOf(taskEntity.getNumber()));
                    });
            start.setDisable(true);
        } catch (Exception x) {
            Alert alert = AlertWindow.getAlertInformation("Error", "Ошбка подключения к базе данных.");
            alert.showAndWait();
        }

    }
}
