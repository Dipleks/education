package edumath.controller;

import edumath.model.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {

    @FXML
    private Pane math;
    @FXML
    private Pane en;

    @FXML
    private void getMath() {
        en.setVisible(false);
        math.setVisible(true);
    }

    @FXML
    private void getEn() {
        math.setVisible(false);
        en.setVisible(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


    @FXML
    private void restore() {
        Task.restoreTask();
        //TODO доработать: вызвать новое окно с вариантами восстановления
        // для начала будет одна активная кнопка "Восстановить Задачи по дефолту"
    }
}
