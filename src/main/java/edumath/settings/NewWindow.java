package edumath.settings;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public enum NewWindow {

    WINDOW {
        public void create(String fxml, Stage window, String title, boolean alwaysOnTop) {

            FXMLLoader fxmlLoader = new FXMLLoader(Root.class.getResource(fxml));
            try {
                Scene scene = new Scene(fxmlLoader.load());
//                scene.setFill(Color.TRANSPARENT);
//                window.initStyle(StageStyle.TRANSPARENT);
                window.setScene(scene);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            window.getIcons().add(new Image("/icone.png"));
            window.setTitle(title);
            window.setAlwaysOnTop(alwaysOnTop);
            window.show();
        }
    };

    public abstract void create(
            String fxml,
            Stage window,
            String title,
            boolean alwaysOnTop
    );
}
