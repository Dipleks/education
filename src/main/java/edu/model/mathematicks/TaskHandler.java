package edu.model.mathematicks;

import edu.model.config.TaskConfig;
import edu.model.database.TasksDAO;
import edu.model.entity.Task;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TaskHandler {
    private static final AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(TaskConfig.class);
    private static final TasksDAO TASK_HANDLER =
            context.getBean("tasksDAO", TasksDAO.class);

    public static void updateStatus(int id) {
        TASK_HANDLER.updateStatus(id);
        context.close();
    }

    public static void addNewTask(String condition, String answer) {
        TASK_HANDLER.add(condition, answer);
        context.close();
    }

    public static void updateTask(int id, String condition, String answer, boolean status) {
        Task upTask = new Task();
        upTask.setCondition(condition);
        upTask.setAnswer(answer);
        upTask.setStatus(status);
        TASK_HANDLER.update(id, upTask);
    }
}