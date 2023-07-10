package edumath.model;

import edumath.database.TaskDataBase;
import edumath.model.entity.TaskEntity;

import java.io.*;
import java.nio.charset.StandardCharsets;
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
        new Task().restore().forEach(TaskDataBase.TASKS::restore);
    }

    private static void save(int number, String condition, String answer) {
        try {
            InputStream is = Task.class.getResourceAsStream("/database/math/backup-task.sql");
            if (null == is) {
                throw new FileNotFoundException("/database/math/backup-task.sql");
            }
            File fileSQL = new File(String.valueOf(is));
            FileWriter fileWriterSQL = new FileWriter(fileSQL, true);
//            BufferedWriter in = new BufferedWriter(fileWriterSQL);
            String sqlElement =
                    "INSERT INTO task (number, condition, answer) VALUES (" +
                            number + ", '" + condition + "', '" + answer + "');";
//            in.write(sqlElement);
            fileWriterSQL.write(sqlElement);
//            in.close();
            fileWriterSQL.close();
            is.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<String> restore() {
        List<String> listSQL = new ArrayList<>();
        try (InputStream is = Task.class.getResourceAsStream("/database/math/backup-task.sql")) {
            if (null == is) {
                throw new FileNotFoundException("/database/math/backup-task.sql");
            }
            try (BufferedReader in = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
                String line;
                while ((line = in.readLine()) != null) {
                    listSQL.add(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listSQL;
    }
}
