package denis.zagorodnev.view.settings;

import javafx.stage.Screen;

public enum SizeWindow {
    HEIGHT("Высота") {
        public double setSize(double size) {
            double height = Screen.getPrimary().getBounds().getHeight();
            if (size > 0) {
                return height / size;
            }
            return height;
        }
    },
    WIDTH("Ширина") {
        public double setSize(double size) {
            double width = Screen.getPrimary().getBounds().getWidth();
            if (size > 0) {
                return width / size;
            }
            return width;
        }
    };

    SizeWindow(String name) {
    }

    public abstract double setSize(double size);
}
