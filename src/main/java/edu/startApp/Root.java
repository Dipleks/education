package edu.startApp;

import edu.model.mathematicks.Tasks;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Root extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void init() throws Exception{
        Tasks.copyTasksInBufferTable();
    }

    @Override
    public void start(Stage primaryStage) {
        RootWindow.getGeneralWindows();
    }

    @Override
    public void stop() throws Exception {
        Tasks.clearBufferTable();
    }
}