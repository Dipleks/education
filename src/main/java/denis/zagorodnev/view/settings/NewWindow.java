package denis.zagorodnev.view.settings;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class NewWindow {

    private NewWindow() {
    }

    public static void getNewWindow(
            String fxml, Stage window, double width, double height, String title, boolean alwaysOnTop)
            throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Root.class.getResource(
                fxml));
        window.setScene(new Scene(fxmlLoader.load(), width, height));
        window.getIcons().add(new Image("/icone.png"));
        window.setTitle(title);
        window.setAlwaysOnTop(alwaysOnTop);
        window.show();
    }
}
