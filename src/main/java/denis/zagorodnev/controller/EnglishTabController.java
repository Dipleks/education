package denis.zagorodnev.controller;

import denis.zagorodnev.view.englishtab.NewWord;
import denis.zagorodnev.view.englishtab.NewWordOld;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class EnglishTabController {

    public Label connectDB;

    @FXML
    public void addWord() throws IOException {
       // NewWordOld.getWordsWindow();
        NewWord.getWordsWindow();
    }
}