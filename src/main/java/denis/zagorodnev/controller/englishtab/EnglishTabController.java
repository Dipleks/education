package denis.zagorodnev.controller.englishtab;

import denis.zagorodnev.database.TopWordsDatabase;
import denis.zagorodnev.model.entity.TopWordsEntity;
import denis.zagorodnev.view.englishtab.NewWord;
import denis.zagorodnev.view.settings.Root;
import denis.zagorodnev.view.settings.SizeWindow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EnglishTabController implements Initializable {

    @FXML
    private Pane rootPane;
    @FXML
    private TableView<TopWordsEntity> topTableWord;
    @FXML
    private TableColumn<TopWordsEntity, String> original;
    @FXML
    private TableColumn<TopWordsEntity, String> translation;

    private static final String FXML_URL_TASK = "/denis/zagorodnev/tasks-in-english.fxml";

    private final ObservableList<TopWordsEntity> list =
            FXCollections.observableArrayList(TopWordsDatabase.getTopWords());

    @FXML
    private void addWord() {
        NewWord.getWordsWindow();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        topTableWord.setLayoutX(SizeWindow.getRootWindowWIDTH() / 2 - original.getWidth());
        topTableWord.setLayoutY(SizeWindow.getRootWindowHEIGHT() / 6);
        original.setCellValueFactory(new PropertyValueFactory<TopWordsEntity, String>("original"));
        translation.setCellValueFactory(new PropertyValueFactory<TopWordsEntity, String>("translation"));
        topTableWord.setItems(list);
    }

    @FXML
    private void passTest() {
        rootPane.getChildren().clear();
        try {
            rootPane.getChildren().add(
                    new FXMLLoader(Root.class.getResource(FXML_URL_TASK)).load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}