package denis.zagorodnev.controller.englishtab;

import denis.zagorodnev.database.TopWordsDatabase;
import denis.zagorodnev.model.entity.TopWordsEntity;
import denis.zagorodnev.view.englishtab.NewWord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;

public class EnglishTabController implements Initializable {

    @FXML
    private Label connectDB;
    @FXML
    private TableView<TopWordsEntity> topTableWord;
    @FXML
    private TableColumn<TopWordsEntity, String> original;
    @FXML
    private TableColumn<TopWordsEntity, String> translation;

    private final ObservableList<TopWordsEntity> list =
            FXCollections.observableArrayList(TopWordsDatabase.getTopWords());

    @FXML
    private void addWord() {
        NewWord.getWordsWindow();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        original.setCellValueFactory(new PropertyValueFactory<TopWordsEntity, String>("original"));
        translation.setCellValueFactory(new PropertyValueFactory<TopWordsEntity, String>("translation"));
        topTableWord.setItems(list);
    }

    @FXML
    public void passTest() {
        // TODO вызов окна с вкладками тест слов, тест предложений и тд
    }
}