package edu.startApp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class RootWindow {
    private static final Stage WINDOW = new Stage();
    private static final String TITLE_WINDOW = "Школьный Мастер";
    private static final String FXML_URL = "/view/root.fxml";

    private RootWindow() {
    }

    public static void getGeneralWindows() {
        FXMLLoader fxmlLoader = new FXMLLoader(Root.class.getResource(FXML_URL));
        try {
            Scene scene = new Scene(fxmlLoader.load());
            WINDOW.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        WINDOW.getIcons().add(new Image("/icone.png"));
        WINDOW.setTitle(TITLE_WINDOW);
        WINDOW.setAlwaysOnTop(false);
        WINDOW.show();
        WINDOW.setResizable(true);
        WINDOW.setMaximized(true);
    }
}