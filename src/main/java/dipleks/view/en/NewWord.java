package dipleks.view.en;

import dipleks.view.settings.NewWindow;
import dipleks.view.settings.SizeWindow;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import java.util.Optional;

public class NewWord {

    private static final double WIDTH = SizeWindow.WIDTH.setSize(3);
    private static final double HEIGHT = SizeWindow.HEIGHT.setSize(2);
    private static final Stage WINDOW = new Stage();
    private static final boolean ALWAYS_ON_TOP = true;
    private static final String TITLE_WINDOW = "Добавить новое слово";
    private static final String FXML_URL = "/dipleks/view.en/new-word.fxml";

    private NewWord() {
    }

    public static void getWordsWindow() {
        NewWindow.WINDOW.create(
                FXML_URL,
                WINDOW,
                WIDTH,
                HEIGHT,
                TITLE_WINDOW,
                ALWAYS_ON_TOP
        );
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