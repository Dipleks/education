package dipleks.model.en;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BackupWords {
    public static void saveWordInFile(String original, String translation) {
        try {
            File fileSQL = new File("src/main/resources/database/backup-words.sql");
            FileWriter fileWriterSQL = new FileWriter(fileSQL, true);
            String sqlElement =
                    "INSERT INTO words (original, translation) VALUES ('" +
                            original + "', '" + translation + "');";
            fileWriterSQL.write(sqlElement + "\n");
            fileWriterSQL.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}