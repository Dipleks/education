package dipleks.database;

import org.springframework.jdbc.core.JdbcTemplate;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriterBackupWordInDB {

    public static void writeDown() {
        try {
            File fileSQL = new File("src/main/resources/database/backup-words.sql");
            FileReader fileReaderSQL = new FileReader(fileSQL);

            List<String> listSQL = new ArrayList<>();
            Scanner readSQLFile = new Scanner(fileReaderSQL);
            while (readSQLFile.hasNextLine()) {
                listSQL.add(readSQLFile.nextLine());
            }
            readSQLFile.close();

            JdbcTemplate template = new JdbcTemplate(DataSourceProvider.INSTANCE.getDataSource());
            template.update("TRUNCATE words;"); // удаляем все значения из таблицы, во избежание дублекатов
            for (String requestSQL : listSQL) {
                template.update(requestSQL);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
