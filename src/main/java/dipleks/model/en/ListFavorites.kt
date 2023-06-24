package dipleks.model.en

import dipleks.database.ListWordsDatabase
import dipleks.database.entity.DictionaryEntity
import javafx.collections.FXCollections
import javafx.collections.ObservableList

class ListFavorites {
    fun getListFavorites() : ObservableList<DictionaryEntity> =
        FXCollections.observableArrayList(ListWordsDatabase.getWordsFavorites())
}