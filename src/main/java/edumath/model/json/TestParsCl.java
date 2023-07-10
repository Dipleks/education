package edumath.model.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edumath.database.DataSourceProvider;
import edumath.database.TaskDataBase;
import edumath.model.entity.TaskEntityJSON;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestParsCl {
    public static void main(String[] args) {
//        TaskEntity taskEntity = new TaskEntity(4, "Task1", "5", false);
//        System.out.println(taskEntity.toString());

//        TaskEntity taskEntity = new TaskEntity("Test Task Json");


        // Записываем новые данные
//        new TaskHandler().set(taskEntity.setNumber(1).getNumber(),
//                taskEntity.getCondition(),
//                taskEntity.setAnswer("5").getAnswer());

        // Читаем все данные
//        new TaskHandler().get().forEach(System.out::println);

//        ObjectMapper objectMapper = new ObjectMapper();
//        String j = new TaskHandler().get().get(0);
//        try {
//            TaskEntityJSON value = objectMapper.readValue(j, TaskEntityJSON.class);
//            System.out.println(value.getNumber());
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }


        TaskHandler taskHandler = new TaskHandler();
        taskHandler.getList().forEach(taskEntityJSON -> {
            System.out.println(taskEntityJSON.getNumber());
            TaskDataBase.TASKS.deleteAll();
            new JdbcTemplate(DataSourceProvider.INSTANCE.getDataSource()).update(
                    String.format(
                            "INSERT INTO task (number, condition, answer) VALUES ('%s', '%s', '%s')",
                            taskEntityJSON.getNumber(),
                            taskEntityJSON.getCondition(),
                            taskEntityJSON.getAnswer()
                    )
            );
        });
    }
}
