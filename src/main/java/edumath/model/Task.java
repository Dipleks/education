package edumath.model;

import edumath.database.TaskDataBase;
import edumath.model.entity.TaskEntity;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task {

    private static final String BACKUP_TASK = "src/main/resources/database/math/backup-task.sql";
    public static void add(int number, String condition, String answer) {
        TaskDataBase.TASKS.add(number, condition, answer);
        save(number, condition, answer);
    }

    public static List<TaskEntity> getTask() {
        return TaskDataBase.TASKS.get();
    }

    public static void editStatus(int number, String condition, String answer, boolean status) {
        TaskDataBase.TASKS.edit(number, condition, answer, status);
    }

    public static void restoreTask() {
        TaskDataBase.TASKS.deleteAll();
        restore().forEach(TaskDataBase.TASKS::restore);
    }

    private static void save(int number, String condition, String answer) {
        try {
            File fileSQL = new File(BACKUP_TASK);
            FileWriter fileWriterSQL = new FileWriter(fileSQL, true);
            String sqlElement =
                    "INSERT INTO task (number, condition, answer) VALUES (" +
                            number + ", '" + condition + "', '" + answer + "');";
            fileWriterSQL.write(sqlElement + "\n");
            fileWriterSQL.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> restore() {
        List<String> listSQL = new ArrayList<>();
        try {
            File fileSQL = new File(BACKUP_TASK);
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
}
