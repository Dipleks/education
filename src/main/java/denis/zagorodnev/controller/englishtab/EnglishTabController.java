package denis.zagorodnev.controller.englishtab;

import denis.zagorodnev.view.englishtab.NewWord;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class EnglishTabController {

    public Label connectDB;

    @FXML
    public void addWord() throws IOException {
        NewWord.getWordsWindow();
    }
}