package denis.zagorodnev.model.db;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BackupDatabase {
    public static void saveWordInFile(String original, String translation) {
        try {
            File fileSQL = new File("src/main/resources/save/words.sql");
            File fileJson = new File("src/main/resources/save/words.txt");
            FileWriter fileWriterSQL = new FileWriter(fileSQL, true);
            FileWriter fileWriterJson = new FileWriter(fileJson, true);

            String sqlElement =
                    "INSERT INTO public.words (original, translation) VALUES ('" +
                            original + "', '" + translation + "');";

            String jsonElement =
                    "{" +
                            "\"original\":\"" + original + "\"," +
                            "\"translation\":\"" + translation +
                            "\"}";

            fileWriterSQL.write(sqlElement + "\n");
            fileWriterJson.write(jsonElement + ",\n");
            fileWriterSQL.close();
            fileWriterJson.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
