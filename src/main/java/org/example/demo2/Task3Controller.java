package org.example.demo2;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Task3Controller {
    @FXML
    private CheckBox dish1, dish2, dish3;
    @FXML
    private TextField quantity1, quantity2, quantity3;
    @FXML
    private Label orderSummary, totalPrice;

    @FXML
    private void initialize() {
        setNumericOnly(quantity1);
        setNumericOnly(quantity2);
        setNumericOnly(quantity3);
    }


    private void setNumericOnly(TextField textField) {
        textField.setOnKeyTyped(event -> {
            if (!Character.isDigit(event.getCharacter().charAt(0))) {
                event.consume();
            }
        });
    }

    @FXML
    private void updateOrder() {
        int sum = 0;
        StringBuilder summary = new StringBuilder("Ваш заказ: ");

        // Блюдо 1
        if (dish1.isSelected()) {
            int qty1 = getQuantity(quantity1);
            int price1 = 300 * qty1;
            sum += price1;
            summary.append("Шашлык машлык (" + qty1 + " шт.) - " + price1 + " руб., ");
        }

        // Блюдо 2
        if (dish2.isSelected()) {
            int qty2 = getQuantity(quantity2);
            int price2 = 150 * qty2;
            sum += price2;
            summary.append("бёрн (" + qty2 + " шт.) - " + price2 + " руб., ");
        }

        // Блюдо 3
        if (dish3.isSelected()) {
            int qty3 = getQuantity(quantity3);
            int price3 = 200 * qty3;
            sum += price3;
            summary.append("литр энжера (" + qty3 + " шт.) - " + price3 + " руб., ");
        }


        if (summary.length() > 12) {
            summary.setLength(summary.length() - 2);
        }

        orderSummary.setText(summary.toString());
        totalPrice.setText("Итоговая сумма: " + sum + " руб.");
    }

    // Метод для получения количества с проверкой на корректность (нельзя отрицательное число)
    private int getQuantity(TextField quantityField) {
        try {
            int qty = Integer.parseInt(quantityField.getText());
            if (qty < 0) {
                return 0; // Если количество отрицательное, считаем 0
            }
            return qty;
        } catch (NumberFormatException e) {
            return 0; // Если введено не число, считаем количество равным 0
        }
    }
}
