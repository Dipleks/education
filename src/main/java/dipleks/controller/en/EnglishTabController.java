package dipleks.controller.en;

import dipleks.view.en.RootWindow;
import dipleks.model.database.entity.TopWordsEntity;
import dipleks.model.en.ListWords;
import dipleks.view.en.NewWordWindow;
import dipleks.view.settings.Root;
import dipleks.view.settings.SizeWindow;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EnglishTabController implements Initializable {

    @FXML
    private MenuBar menuBar;
    @FXML
    private TabPane tabPane;
    @FXML
    private TextField search;
    @FXML
    private VBox topTableWordPane;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private TableView<TopWordsEntity> topTableWord;
    @FXML
    private TableColumn<TopWordsEntity, String> original;
    @FXML
    private TableColumn<TopWordsEntity, String> translation;

    private static final String FXML_URL_TASK = "/dipleks/view.en/tasks-in-english.fxml";
    private static final String FXML_URL_DICTIONARY = "/dipleks/view.en/dictionary-word.fxml";

    @FXML
    private void addWord() {
        NewWordWindow.getWordsWindow();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menuBar.setPrefWidth(SizeWindow.getRootWindowWIDTH());
        tabPane.setPrefWidth(SizeWindow.getRootWindowWIDTH());
        topTableWordPane.setLayoutX(SizeWindow.getRootWindowWIDTH() / 2 - original.getWidth());
        topTableWordPane.setLayoutY(SizeWindow.getRootWindowHEIGHT() / 6);
        original.setCellValueFactory(new PropertyValueFactory<>("original"));
        translation.setCellValueFactory(new PropertyValueFactory<>("translation"));
        try {
            topTableWord.setItems(ListWords.getListWords());
        } catch (Exception e) {
            RootWindow.getErrorDatabaseConnect();
        }
    }

    @FXML
    private void passTest() {
        getFXML(FXML_URL_TASK);
    }

    @FXML
    private void getDictionary() {
        getFXML(FXML_URL_DICTIONARY);
    }

    private void getFXML(String fxml) {
        rootPane.getChildren().clear();
        try {
            rootPane.getChildren().add(
                    new FXMLLoader(Root.class.getResource(fxml)).load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}