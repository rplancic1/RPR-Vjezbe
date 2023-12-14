package ba.unsa.etf.rpr;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalcController {

    private SimpleStringProperty displayText = new SimpleStringProperty("");
    public SimpleStringProperty displayText() {
        return displayText;
    }
    public String getDisplayText() {
        return displayText.get();
    }

    public CalcController() {
        displayText = new SimpleStringProperty("");
    }

    @FXML
    private Label display;
    private double val = 0;
    private String op = "";
    @FXML
    public void initialize() {
        display.textProperty().bind(displayText);
    }
    @FXML
    public void onNumberClick(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        String btn = button.getText();
        if(!displayText.get().contains(".") || !btn.equals(".")) {
            displayText.set(displayText.get() + btn);
        }
    }
    @FXML
    protected void onOperatorClick(ActionEvent event) {
        Button button = (Button) event.getSource();
        String buttonText = button.getText();
        performOperation();
        op = buttonText;
        val = Double.parseDouble(displayText.get());
        displayText.set("");
    }
    @FXML
    protected void onEqualClick(ActionEvent event) {
        performOperation();
    }
    private void performOperation(){
        if(!op.isEmpty()) {
            double newValue = Double.parseDouble(displayText.get());

            switch (op) {
                case "+":
                    val = val + newValue;
                    break;
                case "-":
                    val = val - newValue;
                    break;
                case "X":
                    val = val * newValue;
                    break;
                case "/":
                    val = val / newValue;
                    break;
                case "%":
                    val = val % newValue;
                    break;
                default:
                    break;
            }
            displayText.set(String.valueOf(val));
            op = "";
        }
    }
}
