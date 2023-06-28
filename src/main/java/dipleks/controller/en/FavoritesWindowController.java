package dipleks.controller.en;

import dipleks.database.entity.DictionaryEntity;
import dipleks.model.en.Words;
import dipleks.view.en.Favorites;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class FavoritesWindowController implements Initializable {

    @FXML
    private VBox favoritesPane;
    @FXML
    private TableView<DictionaryEntity> favoritesTable;
    @FXML
    private TableColumn<DictionaryEntity, String> original;
    @FXML
    private TableColumn<DictionaryEntity, String> translation;
    @FXML
    private TableColumn<DictionaryEntity, Boolean> favorites;

    private ObservableList<DictionaryEntity> dictionary;


    @FXML
    private void saveChange() {
        Words.LIST.updateFavorites(dictionary);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        original.setCellValueFactory(new PropertyValueFactory<>("original"));
        translation.setCellValueFactory(new PropertyValueFactory<>("translation"));
        favorites.setCellValueFactory(new PropertyValueFactory<>("favorites"));

        try {
            dictionary = Words.LIST.showFavorites();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        favoritesTable.setItems(dictionary);

        favoritesPane.setPrefWidth(Favorites.getHEIGHT());
        favoritesPane.setPrefHeight(Favorites.getHEIGHT());

    }
}
