package dipleks.model.en;

import dipleks.model.database.NewWordDatabase;

public class NewWord {

    private NewWord() {
    }

    public static void addWord(String inputInEng, String inputTranslation) {
        NewWordDatabase.addWord(inputInEng.trim(), inputTranslation.trim());
        BackupWords.saveWordInFile(inputInEng.trim(), inputTranslation.trim());
    }
}
