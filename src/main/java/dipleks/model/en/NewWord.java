package dipleks.model.en;

import dipleks.database.NewWordDataBase;

public class NewWord {

    private NewWord() {
    }

    public static void addWord(String inputInEng, String inputTranslation) {
        NewWordDataBase.NEW_WORD.add(inputInEng.trim(), inputTranslation.trim());
        BackupWords.saveWordInFile(inputInEng.trim(), inputTranslation.trim());
    }
}
