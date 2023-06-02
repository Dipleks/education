package denis.zagorodnev.view.settings;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class ErrorAddWord {

    private static final double WIDTH = SizeWindow.WIDTH.setSize(4.5);
    private static final double HEIGHT = SizeWindow.HEIGHT.setSize(4);
    private static final Stage ERROR = new Stage();
    private static Stage WINDOW;

    public static void getErrorAddWord(Stage window) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Root.class.getResource(
                "/denis/zagorodnev/error-add-word.fxml"));
        WINDOW = window;
        ERROR.setScene(new Scene(fxmlLoader.load(),WIDTH,HEIGHT));
        ERROR.getIcons().add(new Image("/icone.png"));
        ERROR.setTitle("Error");
        ERROR.setAlwaysOnTop(true);
        ERROR.show();

        if (window != null) {
            ERROR.setOnCloseRequest(event -> window.show());
            window.close();
        }
    }

    public static void getPushOK() {
        ERROR.close();
        WINDOW.show();
    }
}
