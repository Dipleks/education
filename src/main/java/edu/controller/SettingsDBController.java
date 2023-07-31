package edu.controller;

import edu.model.SettingsDB;
import javafx.fxml.FXML;

public class SettingsDBController implements MyController {

    @FXML
    private void createDB() {
        SettingsDB.createDB();
    }

    @FXML
    private void createTableBuffer() {
        SettingsDB.createTableBuffer();
    }

    @FXML
    private void createTableTasks() {
        SettingsDB.createTableTasks();
    }
    @Override
    public void setData() {

    }
}
