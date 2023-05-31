package denis.zagorodnev.model.entity;

public class WordsEntity {
    private int id;
    private String original;
    private String translation;

    public int getId() {
        return id;
    }

    public WordsEntity setId(int id) {
        this.id = id;
        return this;
    }

    public String getOriginal() {
        return original;
    }

    public WordsEntity setOriginal(String original) {
        this.original = original;
        return this;
    }

    public String getTranslation() {
        return translation;
    }

    public WordsEntity setTranslation(String translation) {
        this.translation = translation;
        return this;
    }
}
