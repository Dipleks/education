package dipleks.view.math;

import javafx.scene.control.Tab;

public class MathTab {

    private static final Tab MATH_TAB = new Tab("Математика");

    public static Tab getTab() {

        MATH_TAB.closableProperty().setValue(false);

        return MATH_TAB;
    }
}
