package edumath.controller.math;

import edumath.model.Task;
import edumath.view.AlertWindow;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.Optional;

public class MathAddTaskController {

    @FXML
    private TextField number;
    @FXML
    private TextArea condition;
    @FXML
    private TextField answer;

    @FXML
    private void add() {
        String num = number.getText().trim();
        String con = condition.getText().trim();
        String ans = answer.getText().trim();

        if (!num.equals("") && !con.equals("") && !ans.equals("")) {
            try {
                int number = Integer.parseInt(num);
                Task.add(number, con, ans);
            } catch (NumberFormatException e) {
                getAlarm("Проверте ввод номера задачи!\n" +
                        "Используйте только цифры!");
            }

        } else {
            getAlarm("Есть не заполненые поля!");
        }
        number.clear();
        condition.clear();
        answer.clear();
    }

    private void getAlarm(String info) {
        MathController.NEW_TASK.close();
        Alert alert = AlertWindow.getAlertInformation("Information error", info);
        Optional<ButtonType> press = alert.showAndWait();
        if (press.isPresent()) {
            MathController.NEW_TASK.show();
        }
    }
}
