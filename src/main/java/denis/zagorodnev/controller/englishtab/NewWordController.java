package denis.zagorodnev.controller.englishtab;

import denis.zagorodnev.view.englishtab.NewWord;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import java.net.URL;
import java.util.ResourceBundle;

public class NewWordController implements Initializable {

    @FXML
    private TextField original;
    @FXML
    private TextField translation;
    @FXML
    private StackPane newWordPane;

    @FXML
    private void addWord() {
        NewWord.addWord(original, translation);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        newWordPane.setPrefWidth(NewWord.getWIDTH());
        newWordPane.setPrefHeight(NewWord.getHEIGHT());
    }
}
