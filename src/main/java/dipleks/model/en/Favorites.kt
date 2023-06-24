package dipleks.model.en

import dipleks.database.ListWordsDatabase
import dipleks.database.entity.DictionaryEntity
import javafx.collections.ObservableList

class Favorites {

    fun getListFavorites(listWord : ObservableList<DictionaryEntity>) =
        try {
            for (dictionary in listWord) {
                val isSelected = dictionary.favorites.isSelected
                ListWordsDatabase.changeFavoritesList(isSelected, dictionary.original)
            }
        } catch (e : Exception) {
            throw RuntimeException(e)
        }
}