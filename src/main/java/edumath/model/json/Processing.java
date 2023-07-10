package edumath.model.json;

import java.util.List;

public interface Processing {
    void set(int number, String condition, String answer); // добавляем новую задачу
    List<String> get(); // получаем одну задачу
    void changeStatus(boolean status); // изменить статус верно решенной задачи на true

    // TODO методы ниже в перспективе (на данный момент не актуальны)
    void edit(); // редактрируем задачу
    void delete(); // удаляем задачу
}
