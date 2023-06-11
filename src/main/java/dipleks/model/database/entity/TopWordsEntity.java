package dipleks.model.database.entity;

public class TopWordsEntity {
    String original;
    String translation;
    String favorites;

    public TopWordsEntity(String name, String fam) {
        this.original = name;
        this.translation = fam;
    }

    public String getOriginal() {
        return original;
    }

    public String getTranslation() {
        return translation;
    }

    public String getFavorites() {
        return favorites;
    }

    public void setFavorites(String favorites) {
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