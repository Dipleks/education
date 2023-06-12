package dipleks.controller.en;

import dipleks.view.en.RootWindow;
import dipleks.model.database.entity.DictionaryEntity;
import dipleks.model.en.ListWords;
import dipleks.view.en.NewWordWindow;
import dipleks.view.settings.Root;
import dipleks.view.settings.SizeWindow;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
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
    private TableView<DictionaryEntity> topTableWord;
    @FXML
    private TableColumn<DictionaryEntity, String> original;
    @FXML
    private TableColumn<DictionaryEntity, String> translation;
    @FXML
    private TableColumn<DictionaryEntity, Boolean> favorites;


    private static final String FXML_URL_TASK = "/dipleks/view.en/tasks-in-english.fxml";
    private static final String FXML_URL_DICTIONARY = "/dipleks/view.en/dictionary-word.fxml";
    private static final double WIDTH = SizeWindow.getRootWindowWIDTH();
    private static final double HEIGHT = SizeWindow.getRootWindowHEIGHT();

    @FXML
    private void addWord() {
        NewWordWindow.getWordsWindow();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getSizeView();
        topTableWordPane.setLayoutY(HEIGHT / 6);
        getSearchableDictionary();
    }

    private void getSearchableDictionary() {

        original.setCellValueFactory(new PropertyValueFactory<>("original"));
        translation.setCellValueFactory(new PropertyValueFactory<>("translation"));
        favorites.setCellFactory(e -> new CheckBoxTableCell<>());
        try {
            final ObservableList<DictionaryEntity> dictionary = ListWords.getListWords();
            topTableWord.setItems(dictionary);

            FilteredList<DictionaryEntity> filteredList =
                    new FilteredList<>(dictionary, b -> true);
            search.textProperty().addListener((observable, oldValue, newValue) ->
                    filteredList.setPredicate(topWordsEntity -> {

                if (newValue.isEmpty() || newValue.isBlank()) {
                    return true;
                }

                String searchKeyword = newValue.toLowerCase();

                if (topWordsEntity.getOriginal().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else return topWordsEntity.getTranslation().toLowerCase().contains(searchKeyword);
            }));

            SortedList<DictionaryEntity> sortedList = new SortedList<>(filteredList);
            sortedList.comparatorProperty().bind(dictionary.sorted().comparatorProperty());
            topTableWord.setItems(sortedList);
        } catch (Exception e) {
            RootWindow.getErrorDatabaseConnect();
        }
    }

    @FXML
    private void passTest() {
        getFXML();
    }

    private void getFXML() {
        rootPane.getChildren().clear();
        try {
            rootPane.getChildren().add(
                    new FXMLLoader(Root.class.getResource(EnglishTabController.FXML_URL_TASK)).load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void getSizeView() {
        menuBar.setPrefWidth(WIDTH);
        tabPane.setPrefWidth(WIDTH);

        original.setPrefWidth(WIDTH / 5);
        translation.setPrefWidth(WIDTH / 5);
        favorites.setPrefWidth(WIDTH / 10);
    }
}