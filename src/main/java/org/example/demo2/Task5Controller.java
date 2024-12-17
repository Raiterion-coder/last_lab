package org.example.demo2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class Task5Controller {
    @FXML
    private RadioButton red1, green1, blue2, yellow2;
    @FXML
    private Label result;

    @FXML
    private void drawFlag() {
        StringBuilder flagColors = new StringBuilder();

        // Проверяем выбор цветов для первой группы
        if (red1.isSelected()) {
            flagColors.append("Красный, ");
        }
        if (green1.isSelected()) {
            flagColors.append("Зеленый, ");
        }

        // Проверяем выбор цветов для второй группы
        if (blue2.isSelected()) {
            flagColors.append("Синий, ");
        }
        if (yellow2.isSelected()) {
            flagColors.append("Желтый, ");
        }

        // Если никаких цветов не выбрано
        if (flagColors.length() == 0) {
            result.setText("Не выбраны цвета флага.");
        } else {
            // Убираем последнюю запятую и пробел
            flagColors.setLength(flagColors.length() - 2);
            result.setText("Цвета флага: " + flagColors.toString());
        }
    }


}
