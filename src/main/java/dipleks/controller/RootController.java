package dipleks.controller;

import dipleks.view.settings.SizeRootWindow;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {

    private static final double WIDTH = SizeRootWindow.WIDTH.getSize();
    private static final double HEIGHT = SizeRootWindow.HEIGHT.getSize();

    @FXML
    private MenuBar menuBar;
    @FXML
    private Pane pane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getSizeElements();
    }

    private void getSizeElements() {
        menuBar.setPrefWidth(WIDTH);
        double heightMenuBar = menuBar.getHeight();

        pane.setPrefWidth(WIDTH);
        pane.setPrefHeight(HEIGHT - heightMenuBar);
        pane.setLayoutY(heightMenuBar);
    }
}
