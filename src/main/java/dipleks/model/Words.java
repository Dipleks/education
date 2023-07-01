package dipleks.model;

import dipleks.database.WordsDataBase;
import dipleks.entity.DictionaryEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public enum Words {
    LIST {
        public void add(String inputInEng, String inputTranslation) {
            WordsDataBase.LIST.add(inputInEng.trim(), inputTranslation.trim());
            Backup.LIST.save(inputInEng.trim(), inputTranslation.trim());
        }

        public ObservableList<DictionaryEntity> get() {

            return FXCollections.observableArrayList(WordsDataBase.LIST.get());
        }

        public void updateFavorites(ObservableList<DictionaryEntity> listWord) {
            try {
                for (DictionaryEntity d : listWord) {
                    boolean isSelected = d.getFavorites().isSelected();
                    WordsDataBase.LIST.updateFavorites(isSelected, d.getOriginal());
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public ObservableList<DictionaryEntity> showFavorites() {

            return FXCollections.observableArrayList(WordsDataBase.LIST.showFavorites());
        }
    };

    public abstract void add(String inputInEng, String inputTranslation);

    public abstract ObservableList<DictionaryEntity> get();

    public abstract void updateFavorites(ObservableList<DictionaryEntity> listWord);

    public abstract ObservableList<DictionaryEntity> showFavorites();
}