package edu.controller.english;

import edu.controller.MyController;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.StackPane;

public class EnglishController implements MyController {
    @FXML
    private ToggleButton wordButton;
    @FXML
    private ToggleButton textButton;
    @FXML
    private ToggleButton tableWordsButton;
    @FXML
    private ToggleButton addWordButton;
    @FXML
    private StackPane root;

    @FXML
    private void getWord() {
        root.getChildren().clear();
        isSelected(wordButton, textButton, tableWordsButton, addWordButton);
    }

    @FXML
    private void getText() {
        root.getChildren().clear();
        isSelected(textButton, wordButton, tableWordsButton, addWordButton);
    }

    @FXML
    private void getTableWords() {
        root.getChildren().clear();
        isSelected(tableWordsButton, textButton, wordButton, addWordButton);
    }

    @FXML
    private void addWord() {
        root.getChildren().clear();
        init("/view/english/addNewWord.fxml", new AddNewWordController(), root);
        isSelected(addWordButton, textButton, tableWordsButton, wordButton);
    }

    @Override
    public void setData() {

    }
}
