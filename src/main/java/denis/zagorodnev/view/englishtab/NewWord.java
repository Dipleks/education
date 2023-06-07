package denis.zagorodnev.view.englishtab;

import denis.zagorodnev.database.NewWordDatabase;
import denis.zagorodnev.model.english.WordsBackup;
import denis.zagorodnev.view.settings.NewWindow;
import denis.zagorodnev.view.settings.SizeWindow;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.Optional;

public class NewWord {

    private static final double WIDTH = SizeWindow.WIDTH.setSize(3);
    private static final double HEIGHT = SizeWindow.HEIGHT.setSize(2);
    private static final Stage WINDOW = new Stage();
    private static final boolean ALWAYS_ON_TOP = true;
    private static final String TITLE_WINDOW = "Добавить новое слово";
    private static final String FXML_URL = "/denis/zagorodnev/new-word.fxml";

    private NewWord() {
    }

    public static void getWordsWindow() {
        NewWindow.getNewWindow(
                FXML_URL,
                WINDOW,
                WIDTH,
                HEIGHT,
                TITLE_WINDOW,
                ALWAYS_ON_TOP
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
            getErrorAddWord("Error: trying to add an empty word." +
                    "\nПопытка добавить пустое поле!");
        }
    }

    public static void getErrorAddWord(String infoText) {
        WINDOW.close();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information error");
        alert.setContentText(infoText);
        alert.setHeaderText(null);
        Optional<ButtonType> press = alert.showAndWait();
        if (press.isPresent()) {
            WINDOW.show();
        }
    }

    public static double getWIDTH() {
        return WIDTH;
    }

    public static double getHEIGHT() {
        return HEIGHT;
    }
}
