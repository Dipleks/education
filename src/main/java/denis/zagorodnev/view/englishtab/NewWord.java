package denis.zagorodnev.view.englishtab;

import denis.zagorodnev.database.NewWordDatabase;
import denis.zagorodnev.model.english.WordsBackup;
import denis.zagorodnev.view.settings.NewWindow;
import denis.zagorodnev.view.settings.SizeWindow;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewWord {

    private static final double WIDTH = SizeWindow.WIDTH.setSize(3);
    private static final double HEIGHT = SizeWindow.HEIGHT.setSize(2);
    private static final Stage WINDOW = new Stage();

    private NewWord() {
    }

    public static void getWordsWindow() {
        NewWindow.getNewWindow(
                "/denis/zagorodnev/new-word.fxml",
                WINDOW,
                WIDTH,
                HEIGHT,
                "Добавить новое слово",
                true
        );
    }

    public static void addWord(TextField inputInEng, TextField inputTranslation) {
        String original = inputInEng.getText();
        String translation = inputTranslation.getText();

        if (!original.trim().equals("") && !translation.trim().equals("")) {
            NewWordDatabase.addWord(original, translation);
            WordsBackup.saveWordInFile(original, translation);
            inputInEng.clear();
            inputTranslation.clear();
        } else {
            ErrorAddWord.getErrorAddWord(WINDOW);
        }
    }

    public static double getWIDTH() {
        return WIDTH;
    }

    public static double getHEIGHT() {
        return HEIGHT;
    }
}
