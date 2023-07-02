package edumath.model;

import edumath.database.TaskDataBase;
import edumath.entity.TaskEntity;

import java.util.List;

public class Task {
    public static void add(int number, String condition, String answer) {
        TaskDataBase.TASKS.add(number, condition, answer);
    }

    public static String getCondition() {
        String condition = "Не удалось загрузить задачу!";
        try {
            List<TaskEntity> list = TaskDataBase.TASKS.get();
            for(TaskEntity taskEntity : list) {
                condition = taskEntity.getCondition();
            }
        } catch (Exception e) {
            return "Подключение к БД отсутствует!";
        }

        return condition;
    }
}
