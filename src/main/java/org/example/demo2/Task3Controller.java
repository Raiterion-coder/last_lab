package org.example.demo2;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.util.function.UnaryOperator;

public class Task3Controller {
    @FXML
    private CheckBox dish1, dish2, dish3;
    @FXML
    private TextField quantity1, quantity2, quantity3;
    @FXML
    private Label orderSummary, totalPrice;

    @FXML
    private void initialize() {
        // Добавляем блокировку ввода символов кроме цифр
        setNumericOnly(quantity1);
        setNumericOnly(quantity2);
        setNumericOnly(quantity3);

        // Добавляем слушатель для обновления цены при изменении ввода
        quantity1.textProperty().addListener((observable, oldValue, newValue) -> updateOrder());
        quantity2.textProperty().addListener((observable, oldValue, newValue) -> updateOrder());
        quantity3.textProperty().addListener((observable, oldValue, newValue) -> updateOrder());
    }

    private void setNumericOnly(TextField textField) {
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*")) { // Разрешаем только цифры
                return change;
            }
            return null; // Отклоняем нецифровые символы
        };
        textField.setTextFormatter(new TextFormatter<>(filter));
    }

    @FXML
    private void updateOrder() {
        int sum = 0;
        StringBuilder summary = new StringBuilder("Ваш заказ: ");

        // Обновляем количество и стоимость для Блюда 1
        if (dish1.isSelected()) {
            int qty1 = getQuantity(quantity1);
            int price1 = 100 * qty1;
            sum += price1;
            summary.append("Блюдо 1 (").append(qty1).append(" шт.) - ").append(price1).append(" руб., ");
        }

        // Обновляем количество и стоимость для Блюда 2
        if (dish2.isSelected()) {
            int qty2 = getQuantity(quantity2);
            int price2 = 150 * qty2;
            sum += price2;
            summary.append("Блюдо 2 (").append(qty2).append(" шт.) - ").append(price2).append(" руб., ");
        }

        // Обновляем количество и стоимость для Блюда 3
        if (dish3.isSelected()) {
            int qty3 = getQuantity(quantity3);
            int price3 = 200 * qty3;
            sum += price3;
            summary.append("Блюдо 3 (").append(qty3).append(" шт.) - ").append(price3).append(" руб., ");
        }

        // Удаляем последнюю запятую, если нужно
        if (summary.length() > 12) {
            summary.setLength(summary.length() - 2);
        }

        orderSummary.setText(summary.toString());
        totalPrice.setText("Итоговая сумма: " + sum + " руб.");
    }

    private int getQuantity(TextField textField) {
        try {
            return Integer.parseInt(textField.getText());
        } catch (NumberFormatException e) {
            return 0; // Возвращаем 0, если поле пустое или не число
        }
    }
}
