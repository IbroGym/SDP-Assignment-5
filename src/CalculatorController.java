import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private final CalculatorView view;
    private final CalculatorModel model;

    public CalculatorController(CalculatorView view, CalculatorModel model) {
        this.view = view;
        this.model = model;

        this.view.addOperationListener(new OperationListener());
    }

    class OperationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double firstNum = view.getFirstNumber();
                double secondNum = view.getSecondNumber();
                String result = "";

                switch (view.getOperationCommand(e)) {
                    case "+":
                        result = String.valueOf(model.add(firstNum, secondNum));
                        break;
                    case "-":
                        result = String.valueOf(model.subtract(firstNum, secondNum));
                        break;
                    case "*":
                        result = String.valueOf(model.multiply(firstNum, secondNum));
                        break;
                    case "/":
                        try {
                            result = String.valueOf(model.divide(firstNum, secondNum));
                        } catch (ArithmeticException ex) {
                            result = "Ошибка: деление на ноль";
                        }
                        break;
                }
                view.setResult(result);
            } catch (NumberFormatException ex) {
                view.displayErrorMessage("Ошибка: введите корректные числа");
            }
        }
    }
}
