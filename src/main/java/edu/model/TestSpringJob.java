package edu.model;

import edu.model.config.TaskConfig;
import edu.model.database.TasksDAO;
import edu.model.database.TasksBuffer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpringJob {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                TaskConfig.class
        );

//        TaskDAO taskDAO = new TaskDAO();
//        System.out.println(taskDAO.getCondition(FakeDB.getTasks().get(1)));

//        TaskHandler taskHandler = context.getBean("taskHandler", TaskHandler.class);
//        taskHandler.addTask("test1", "t1");

//        TaskHandler.updateTask(1, "test1", "t1", true);

//        TaskHandlerDB taskHandlerDB = context.getBean("taskHandlerDB", TaskHandlerDB.class);
//        taskHandlerDB.add("test2", "t2");

//        System.out.println(taskHandlerDB.getTask().getCondition());
//        System.out.println(taskHandlerDB.getTask().getNumber());
//        System.out.println(taskHandlerDB.getTask().isStatus());
//        taskHandlerDB.updateStatus(taskHandlerDB.getTask().getNumber());

//        System.out.println(taskHandlerDB.getNextID(3));

//        for (int i = 1; i < 121; i++) {
//            System.out.println("INSERT INTO public.statuses (tasks_id, status) VALUES (" + i + ", false);");
//        }
//        TaskHandlerDB taskHandlerDB = context.getBean("taskHandlerDB", TaskHandlerDB.class);
//        List<Task> list = taskHandlerDB.getTask();
//
//        for (Task t: list) {
//            System.out.println(t.getId());
//        }

//        TaskHandler.checkAnswer("9");

//        TasksDAO tasksDAO = context.getBean("tasksDAO", TasksDAO.class);
//        TasksBuffer tasksBuffer = context.getBean("tasksBuffer", TasksBuffer.class);

//        tasksDAO.getAll().forEach(task -> tasksDAOH2.add(
//                task.getId(), task.getCondition(), task.getAnswer()));

//        System.out.println(tasksDAOH2.getTask().getCondition());
//        System.out.println("----------------");
//        tasksDAOH2.delete(tasksDAOH2.getTask().getId());
//        System.out.println(tasksDAOH2.getTask().getCondition());

//        tasksDAOH2.update(tasksDAO.getTask().getId(), 0);

//        tasksBuffer.deleteAll();
        context.close();
    }
}
