package dipleks.database.entity;

import javafx.scene.control.CheckBox;

public class DictionaryEntity {
    private final String original;
    private final String translation;
    private CheckBox favorites;

    public DictionaryEntity(String name, String fam) {
        this.original = name;
        this.translation = fam;
        this.favorites = new CheckBox();
    }

    public String getOriginal() {
        return original;
    }

    public String getTranslation() {
        return translation;
    }

    public CheckBox getFavorites() {
        return favorites;
    }

    public void setFavorites(CheckBox favorites) {
        this.favorites = favorites;
    }

    @Override
    public String toString() {
        return "TopWordsEntity{" +
                "original='" + original + '\'' +
                ", translation='" + translation + '\'' +
                '}';
    }
}