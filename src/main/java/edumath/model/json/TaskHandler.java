package edumath.model.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edumath.model.entity.TaskEntityJSON;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskHandler implements Processing{

    private static final String BACKUP_TASK = "src/main/resources/json/taskHandler.json";

    @Override
    public void set(int number, String condition, String answer) {
        try {
            File json = new File(BACKUP_TASK);
            FileWriter fileWriterSQL = new FileWriter(json, true);
            // TODO сделать обработку через json
            String jsonValue = "{" +
                    " \"number\" : " + number + ", " +
                    "\"condition\" : \"" + condition + "\", " +
                    "\"answer\" : \"" + answer + "\", " +
                    "\"status\" : true" +
                    " }";
            fileWriterSQL.write(jsonValue + "\n");
            fileWriterSQL.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> /* List<TaskEntityJSON> */get() {
        List<String> listJson = new ArrayList<>();
        try {
            File fileJson = new File(BACKUP_TASK);
            FileReader fileReaderJson = new FileReader(fileJson);
            // TODO сделать обработку через json
            /* TODO передлать в качестве возращаемого значения Map<Integer, String>,
            *   где Integer - number задачи, String - condition задачи или
            *   вернуть только TaskEntityJSON из которого брать данные (что было бы более правильным)*/

            Scanner read = new Scanner(fileReaderJson);

            while (read.hasNextLine()) {
                listJson.add(read.nextLine());
            }
            read.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listJson;
    }

    @Override
    public void changeStatus(boolean status) {

    }

    @Override
    public void edit() {

    }

    @Override
    public void delete() {

    }

    public List<TaskEntityJSON> getList() {
        List<String> listJson = new ArrayList<>();
        try {
            File fileJson = new File(BACKUP_TASK);
            FileReader fileReaderJson = new FileReader(fileJson);
            Scanner read = new Scanner(fileReaderJson);

            while (read.hasNextLine()) {
                listJson.add(read.nextLine());
            }
            read.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        List<TaskEntityJSON> entity = new ArrayList<>();
        listJson.forEach(srt -> {
            try {
                TaskEntityJSON value = objectMapper.readValue(srt, TaskEntityJSON.class);
                entity.add(new TaskEntityJSON(
                        value.getNumber(),
                        value.getCondition(),
                        value.getAnswer(),
                        value.isStatus()
                ));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });

        return entity;
    }
}
