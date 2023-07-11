package edu.model;

import edu.database.TaskDataBase;
import edu.model.entity.TaskEntity;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MathTask {

    public static void add(int number, String condition, String answer) {
        TaskDataBase.TASKS.add(number, condition, answer);
    }

    public static List<TaskEntity> getTask() {
        return TaskDataBase.TASKS.get();
    }

    public static void editStatus(int number, String condition, String answer, boolean status) {
        TaskDataBase.TASKS.edit(number, condition, answer, status);
    }

    public static void restoreTask() {
        TaskDataBase.TASKS.deleteAll();
        new MathTask().restore().forEach(TaskDataBase.TASKS::restore);
    }

    private List<String> restore() {
        List<String> listSQL = new ArrayList<>();
        try (InputStream is = MathTask.class.getResourceAsStream("/database/mathTaskBackup.sql")) {
            if (null == is) {
                throw new FileNotFoundException("/database/mathTaskBackup.sql");
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