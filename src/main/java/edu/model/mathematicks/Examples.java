package edu.model.mathematicks;

public class Examples {

    public static String getFirstValue() {
        int value = (int) (Math.random() * 100);
        return String.valueOf(value);
    }

    public static String getSecondValue() {
        int value = (int) (Math.random() * 100);
        return String.valueOf(value);
    }

    public static String getSign() {
        int value = (int) (Math.random() * 10);
        if (value < 6) {
            return "+";
        }
        return "-";
    }

    public static String getResult(String firstValue, String sign, String secondValue) {
        int first = Integer.parseInt(firstValue);
        int second = Integer.parseInt(secondValue);
        int result;
        if (sign.equals("+")) {
            result = first + second;
        } else {
            result = first - second;
        }
        return String.valueOf(result);
    }
}
