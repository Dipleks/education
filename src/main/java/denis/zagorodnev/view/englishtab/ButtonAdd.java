package denis.zagorodnev.view.englishtab;

import denis.zagorodnev.database.NewWordDatabase;
import denis.zagorodnev.model.english.WordsBackup;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ButtonAdd {

    public static void addWord(TextField inputInEng, TextField inputTranslation, Stage window) {
        String original = inputInEng.getText();
        String translation = inputTranslation.getText();

        if (!original.trim().equals("") && !translation.trim().equals("")) {
            NewWordDatabase.addWord(original, translation);
            WordsBackup.saveWordInFile(original, translation);
            inputInEng.clear();
            inputTranslation.clear();
        } else {
            ErrorAddWord.getErrorAddWord(window);
        }
    }
}
