package edumath.controller.math;

import edumath.model.Task;
import edumath.settings.NewWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MathController {

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
                "/edu/math/math-add-task.fxml",
                NEW_TASK,
                "Добавить новую задачу",
                true);
    }

    @FXML
    public void check() {
        condition.setText("Следующая задача");
        //TODO при нажатии кнопки происходит проверка ответа полученого
        // из textField, в случае верного ответа status в БД меняется
        // на true и происходит переход к сл задаче
    }

    @FXML
    private void startTask() {
        String text = Task.getCondition();
        condition.setText(text);
        start.setDisable(true);
    }
}
