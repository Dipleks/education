package edu.view.settings;

import edu.view.RootWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class Root extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        RootWindow.getGeneralWindows();
    }
}