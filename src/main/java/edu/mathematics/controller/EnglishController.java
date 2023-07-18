package edu.mathematics.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;

public class EnglishController implements MyController {
    @FXML
    private StackPane root;

    @FXML
    private void getWord() {
        root.getChildren().clear();

    }

    @FXML
    private void getText() {
        root.getChildren().clear();

    }

    @FXML
    private void getTableWords() {
        root.getChildren().clear();

    }

    @FXML
    private void addWord() {
        root.getChildren().clear();
        init("/view/addNewWord.fxml", new AddNewWordController(), root);
    }

    @Override
    public void setData() {

    }
}
