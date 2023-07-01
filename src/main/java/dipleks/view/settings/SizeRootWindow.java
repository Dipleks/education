package dipleks.view.settings;

import javafx.stage.Screen;

public enum SizeRootWindow {
    HEIGHT("Высота") {
        @Override
        public double getSize() {
            return Screen.getPrimary().getBounds().getHeight() - 150;
        }
    },
    WIDTH("Ширина") {
        @Override
        public double getSize() {
            return Screen.getPrimary().getBounds().getWidth() - 150;
        }
    };

    SizeRootWindow(String name) {
    }

    public abstract double getSize();
}