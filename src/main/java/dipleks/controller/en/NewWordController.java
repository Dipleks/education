package dipleks.controller.en;

import dipleks.model.en.Words;
import dipleks.view.en.NewWord;
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
        String original = this.original.getText().trim();
        String translation = this.translation.getText().trim();
        if (!original.equals("") && !translation.equals("")) {
            Words.LIST.add(original, translation);
            this.original.clear();
            this.translation.clear();
        } else {
            NewWord.getErrorAddWord("Error: trying to add an empty word." +
                    "\nПопытка добавить пустое поле!");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        newWordPane.setPrefWidth(NewWord.getWIDTH());
        newWordPane.setPrefHeight(NewWord.getHEIGHT());
    }
}
