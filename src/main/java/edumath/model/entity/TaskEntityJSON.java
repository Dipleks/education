package edumath.model.entity;

public class TaskEntityJSON {
    private int number;
    private String condition;
    private String answer;
    private boolean status;

    public TaskEntityJSON() {
    }

    public TaskEntityJSON(String condition) {
        this.condition = condition;
    }

    public TaskEntityJSON(int number, String condition, String answer, boolean status) {
        this.number = number;
        this.condition = condition;
        this.answer = answer;
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public String getCondition() {
        return condition;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isStatus() {
        return status;
    }

    public TaskEntityJSON setNumber(int number) {
        this.number = number;
        return this;
    }

    public TaskEntityJSON setCondition(String condition) {
        this.condition = condition;
        return this;
    }

    public TaskEntityJSON setAnswer(String answer) {
        this.answer = answer;
        return this;
    }

    public TaskEntityJSON setStatus(boolean status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " \"number\" : " + number + ", " +
                "\"condition\" : \"" + condition + "\", " +
                "\"answer\" : \"" + answer + "\", " +
                "\"status\" : " + status + "  " +
                "}";
    }
}
