package denis.zagorodnev.controller;

import denis.zagorodnev.view.englishtab.NewWord;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EnglishTabController {

    public Label connectDB;

    @FXML
    public void addWord() {
        NewWord.getWordsWindow();
    }
}