package dipleks.model;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public enum Backup {
    LIST {
        public void save(String original, String translation) {
            try {
                File fileSQL = new File(BACKUP_FILE);
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

        public List<String> getListSQL() {
            List<String> listSQL = new ArrayList<>();
            try {
                File fileSQL = new File(BACKUP_FILE);
                FileReader fileReaderSQL = new FileReader(fileSQL);
                Scanner readSQLFile = new Scanner(fileReaderSQL);

                while (readSQLFile.hasNextLine()) {
                    listSQL.add(readSQLFile.nextLine());
                }
                readSQLFile.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return listSQL;
        }
    };

    private static final String BACKUP_FILE = "src/main/resources/database/backup-words.sql";

    public abstract void save(String original, String translation);

    public abstract List<String> getListSQL();
}