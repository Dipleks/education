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

    private static final int ID = TASK_HANDLER.getID();

    private static int LIMIT = 2;

    public static String showCondition() {
        LIMIT = 2;
        String condition = TASK_HANDLER.getTask().getCondition();
        context.close();
        return condition;
    }

    public static String nextCondition() {
        String condition = TASK_HANDLER.getTask().getCondition();
        if (LIMIT <= TASK_HANDLER.count()) {
            condition = TASK_HANDLER.getTask(TASK_HANDLER.getNextID(LIMIT)).getCondition();
            context.close();
            LIMIT++;
            return condition;
        } else {
            LIMIT = 1;
        }
        return condition;
    }

    public static String getAnswer() {
        String answer = TASK_HANDLER.getTask(ID).getAnswer();
        context.close();
        return answer;
    }

    public static void updateStatus() {
        TASK_HANDLER.updateStatus(ID);
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
