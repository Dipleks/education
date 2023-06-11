package dipleks.model.database.entity;

public class TopWordsEntity {
    private final String original;
    private final String translation;
    private boolean favorites;

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

    public boolean getFavorites() {
        return favorites;
    }

    public void setFavorites(boolean favorites) {
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