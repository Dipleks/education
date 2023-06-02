package denis.zagorodnev.controller;

import denis.zagorodnev.view.englishtab.NewWordOld;
import denis.zagorodnev.model.db.BackupDatabase;
import denis.zagorodnev.database.NewWordDatabase;
import denis.zagorodnev.view.settings.ErrorAddWord;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class NewWordControllerOld {

    private static boolean SAVE = false;

    public static void addWord(TextField inputInEng, TextField inputTranslation, Stage window) {

        NewWordOld.getAdd().setOnAction(event -> {
            String original = inputInEng.getText();
            String translation = inputTranslation.getText();

            if (!original.trim().equals("") && !translation.trim().equals("")) {
                NewWordDatabase.addWord(original, translation);
                inputInEng.clear();
                inputTranslation.clear();
                SAVE = true;
            } else {
                try {
                    ErrorAddWord.getErrorAddWord(window);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            BackupDatabase.saveWordInFile(original, translation);
        });
    }

    public static boolean isSAVE() {
        return SAVE;
    }
}
