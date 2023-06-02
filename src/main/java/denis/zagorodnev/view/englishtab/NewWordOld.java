package denis.zagorodnev.view.englishtab;

import denis.zagorodnev.controller.NewWordControllerOld;
import denis.zagorodnev.view.settings.SizeWindow;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NewWordOld {
    private static final TextField INPUT_IN_ENG = new TextField();
    private static final TextField INPUT_TRANSLATION = new TextField();
    private static final Button ADD = new Button("Добавить");
    private static final double WIDTH = SizeWindow.WIDTH.setSize(3);
    private static final double HEIGHT = SizeWindow.HEIGHT.setSize(2);
    private static final Stage WINDOW = new Stage();

    public static void getWordsWindow() {
        WINDOW.setScene(new Scene(getWindow(), WIDTH, HEIGHT));
        WINDOW.getIcons().add(new Image("/icone.png"));
        WINDOW.setTitle("Добавить новое слово");
        WINDOW.setAlwaysOnTop(true);
        WINDOW.show();
        NewWordControllerOld.addWord(INPUT_IN_ENG, INPUT_TRANSLATION, WINDOW);
    }

    private static VBox getWindow() {
        getSettingTextField();
        VBox window = new VBox(INPUT_IN_ENG, INPUT_TRANSLATION, ADD);
        window.setSpacing(HEIGHT / 10);
        window.setAlignment(Pos.CENTER);
        return window;
    }

    private static void getSettingTextField() {
        INPUT_IN_ENG.setPromptText("Введите на Английском");
        INPUT_TRANSLATION.setPromptText("Введите на Русском");
        INPUT_IN_ENG.setMaxWidth(WIDTH / 2.5);
        INPUT_TRANSLATION.setMaxWidth(WIDTH / 2.5);
    }

    public static Button getAdd() {
        return ADD;
    }
}
