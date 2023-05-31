package denis.zagorodnev.controller;

import denis.zagorodnev.englishtab.NewWord;
import denis.zagorodnev.settings.SizeWindow;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EnglishTabController {

    public Label connectDB;

    @FXML
    public void addWord() {
        NewWord.getWordsWindow();
    }
}