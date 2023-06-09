package dipleks.model.entity;

public class TopWordsEntity {
    String original;
    String translation;

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

    @Override
    public String toString() {
        return "TopWordsEntity{" +
                "original='" + original + '\'' +
                ", translation='" + translation + '\'' +
                '}';
    }
}