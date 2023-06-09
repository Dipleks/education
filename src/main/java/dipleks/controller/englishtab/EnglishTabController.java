package dipleks.controller.englishtab;

import dipleks.database.TopWordsDatabase;
import dipleks.model.entity.TopWordsEntity;
import dipleks.view.englishtab.NewWord;
import dipleks.view.settings.Root;
import dipleks.view.settings.SizeWindow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EnglishTabController implements Initializable {

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

    private static final String FXML_URL_TASK = "/dipleks/tasks-in-english.fxml";
    private static final String FXML_URL_DICTIONARY = "/dipleks/dictionary-word.fxml";

    private final ObservableList<TopWordsEntity> list =
            FXCollections.observableArrayList(TopWordsDatabase.getTopWords());

    @FXML
    private void addWord() {
        NewWord.getWordsWindow();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        topTableWordPane.setLayoutX(SizeWindow.getRootWindowWIDTH() / 2 - original.getWidth());
        topTableWordPane.setLayoutY(SizeWindow.getRootWindowHEIGHT() / 6);
        original.setCellValueFactory(new PropertyValueFactory<>("original"));
        translation.setCellValueFactory(new PropertyValueFactory<>("translation"));
        topTableWord.setItems(list);
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