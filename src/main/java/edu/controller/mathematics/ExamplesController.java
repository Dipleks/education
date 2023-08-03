package edu.controller.mathematics;

import edu.controller.MyController;
import edu.model.mathematicks.Examples;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ExamplesController implements MyController, Initializable {

    @FXML
    private Label countException;
    @FXML
    private Label countSuccess;
    @FXML
    private ToggleButton buttonAddSub;
    @FXML
    private ToggleButton buttonMultDiv;
    @FXML
    private ToggleButton buttonMoreOrEqual;
    @FXML
    private Label status;
    @FXML
    private Label firstValue;
    @FXML
    private Label secondValue;
    @FXML
    private Label sign;
    @FXML
    private TextField result;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getExample();
        buttonAddSub.setSelected(true);
    }

    @FXML
    private void addAndSub() {
        buttonAddSub.setSelected(true);
        buttonMultDiv.setSelected(false);
        buttonMoreOrEqual.setSelected(false);
    }

    @FXML
    private void moreOrEqual() {
        buttonMoreOrEqual.setSelected(true);
        buttonMultDiv.setSelected(false);
        buttonAddSub.setSelected(false);
    }

    @FXML
    private void multAndDiv() {
        buttonMultDiv.setSelected(true);
        buttonAddSub.setSelected(false);
        buttonMoreOrEqual.setSelected(false);
    }
    @FXML
    private void checkResult() {
        check();
    }

    @FXML
    private void checkResultEntered(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            check();
        }
    }

    private void check() {
        if (result.getText().equals(Examples.getResult(
                firstValue.getText(), sign.getText(), secondValue.getText()
        ))) {
            status.setStyle("-fx-text-fill: green;");
            status.setText("Верно! Молодец!!!");
            int count = Integer.parseInt(countSuccess.getText());
            count++;
            countSuccess.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
            countSuccess.setText(String.valueOf(count));
        } else {
            status.setStyle("-fx-text-fill: red;");
            status.setText("Не верно! Попробуем решить другой пример!");
            int count = Integer.parseInt(countException.getText());
            count++;
            countException.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            countException.setText(String.valueOf(count));
        }
        getExample();
        result.clear();
    }


    private void getExample() {
        String first = Examples.getFirstValue();
        String second = Examples.getSecondValue();
        sign.setText(Examples.getSign());
        if (sign.getText().equals("-")) {
            if (Integer.parseInt(first) < Integer.parseInt(second)) {
                firstValue.setText(second);
                secondValue.setText(first);
            }
        } else {
            firstValue.setText(first);
            secondValue.setText(second);
        }
    }

    public void setData() {
    }
}