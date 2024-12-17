package org.example.demo2;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class Task4Controller {
    @FXML
    private TextField display;

    private double firstOperand = 0;
    private String operator = "";
    private boolean startNew = true;

    @FXML
    private void appendDigit(javafx.event.ActionEvent event) {
        String text = ((Button) event.getSource()).getText();


        if (text.equals(".")) {
            if (display.getText().contains(".")) {
                return; // Если точка уже есть, ничего не делаем
            }
        }

        // Если нужно начать новое число, очищаем экран
        if (startNew) {
            display.clear();
            startNew = false;
        }

        // Добавляем цифру или точку
        display.appendText(text);
    }


    @FXML
    private void chooseOperation(javafx.event.ActionEvent event) {
        firstOperand = Double.parseDouble(display.getText());
        operator = ((Button) event.getSource()).getText();
        startNew = true;
    }

    @FXML
    private void calculate() {
        double secondOperand = Double.parseDouble(display.getText());
        double result;

        // Проверка деления на ноль
        if (operator.equals("/") && secondOperand == 0) {
            display.setText("Ошибка");
            return;
        }

        // Выполнение операции
        switch (operator) {
            case "+" -> result = firstOperand + secondOperand;
            case "-" -> result = firstOperand - secondOperand;
            case "*" -> result = firstOperand * secondOperand;
            case "/" -> result = firstOperand / secondOperand;
            default -> result = 0;
        }

        // Отображение результата
        display.setText(String.valueOf(result));
        startNew = true;
    }


    @FXML
    private void clear() {
        display.clear();
        firstOperand = 0;
        operator = "";
    }
}
