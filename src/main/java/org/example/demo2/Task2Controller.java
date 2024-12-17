package org.example.demo2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class Task2Controller {
    @FXML
    private CheckBox checkBox1, checkBox2, checkBox3;
    @FXML
    private Button button1, button2;
    @FXML
    private TextField textField1;

    @FXML
    private void toggleVisibility1() {
        button1.setVisible(checkBox1.isSelected());
    }

    @FXML
    private void toggleVisibility2() {
        textField1.setVisible(checkBox2.isSelected());
    }

    @FXML
    private void toggleVisibility3() {
        button2.setVisible(checkBox3.isSelected());
    }
}
