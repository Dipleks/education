package edumath.model;

import edumath.database.TaskDataBase;
import edumath.entity.TaskEntity;

import java.util.List;

public class Task {
    public static void add(int number, String condition, String answer) {
        TaskDataBase.TASKS.add(number, condition, answer);
    }

    public static List<TaskEntity> getTask() {
        return TaskDataBase.TASKS.get();
    }

    public static void editStatus(int number, String condition, String answer, boolean status) {
        TaskDataBase.TASKS.edit(number, condition, answer, status);
    }
}
