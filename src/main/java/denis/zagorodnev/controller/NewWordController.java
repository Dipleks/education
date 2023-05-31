package denis.zagorodnev.controller;

import denis.zagorodnev.englishtab.NewWord;
import denis.zagorodnev.model.db.BackupDatabase;
import denis.zagorodnev.model.db.NewWordDatabase;
import denis.zagorodnev.settings.ErrorWindow;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewWordController {

    private static boolean SAVE = false;

    public static void addWord(TextField inputInEng, TextField inputTranslation, Stage window) {

        NewWord.getAdd().setOnAction(event -> {
            String original = inputInEng.getText();
            String translation = inputTranslation.getText();

            if (!original.trim().equals("") && !translation.trim().equals("")) {
                NewWordDatabase.addWord(original, translation);
                inputInEng.clear();
                inputTranslation.clear();
                SAVE = true;
            } else {
                ErrorWindow.getErrorWindow(window,"Попытка добавить пустое поле!");
            }
            BackupDatabase.saveWordInFile(original, translation);
        });
    }

    public static boolean isSAVE() {
        return SAVE;
    }
}
