import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {
    private final JTextField firstNumber = new JTextField(10);
    private final JTextField secondNumber = new JTextField(10);
    private final JButton addButton = new JButton("+");
    private final JButton subtractButton = new JButton("-");
    private final JButton multiplyButton = new JButton("*");
    private final JButton divideButton = new JButton("/");
    private final JTextField resultField = new JTextField(15);

    public CalculatorView() {
        JPanel calcPanel = new JPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 200);

        calcPanel.add(new JLabel("Первое число:"));
        calcPanel.add(firstNumber);
        calcPanel.add(new JLabel("Второе число:"));
        calcPanel.add(secondNumber);

        calcPanel.add(addButton);
        calcPanel.add(subtractButton);
        calcPanel.add(multiplyButton);
        calcPanel.add(divideButton);

        calcPanel.add(new JLabel("Результат:"));
        calcPanel.add(resultField);

        this.add(calcPanel);
    }

    public double getFirstNumber() {
        return Double.parseDouble(firstNumber.getText());
    }

    public double getSecondNumber() {
        return Double.parseDouble(secondNumber.getText());
    }

    public void setResult(String result) {
        resultField.setText(result);
    }

    public void addOperationListener(ActionListener listenForCalcButton) {
        addButton.addActionListener(listenForCalcButton);
        subtractButton.addActionListener(listenForCalcButton);
        multiplyButton.addActionListener(listenForCalcButton);
        divideButton.addActionListener(listenForCalcButton);
    }

    public String getOperationCommand(ActionEvent e) {
        return e.getActionCommand();
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}
