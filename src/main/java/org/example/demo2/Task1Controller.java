package org.example.demo2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Task1Controller {
    @FXML
    private TextField inputField;
    @FXML
    private TextField outputField;
    @FXML
    private Button toggleButton;

    private boolean direction = true;

    @FXML
    private void toggleText() {
        if (direction) {
            outputField.setText(inputField.getText());
            inputField.clear();
            inputField.setEditable(false);
            outputField.setEditable(true);
            toggleButton.setText("←");
        } else {
            inputField.setText(outputField.getText());
            outputField.clear();
            outputField.setEditable(false);
            inputField.setEditable(true);
            toggleButton.setText("→");
        }
        direction = !direction;
    }

}
