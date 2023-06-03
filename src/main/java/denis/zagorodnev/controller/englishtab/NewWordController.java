package denis.zagorodnev.controller.englishtab;

import denis.zagorodnev.view.englishtab.ButtonAdd;
import denis.zagorodnev.view.englishtab.NewWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class NewWordController {

    @FXML
    public TextField original;
    @FXML
    public TextField translation;

    @FXML
    public void addWord(ActionEvent actionEvent) {
        ButtonAdd.addWord(original, translation, NewWord.getWINDOW());
    }
}
